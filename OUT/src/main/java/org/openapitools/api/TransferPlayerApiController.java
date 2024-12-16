package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.apache.commons.codec.binary.Hex;
import org.openapitools.exceptions.BadCredentialsException;
import org.openapitools.exceptions.MessageNotValidException;
import org.openapitools.exceptions.UserAlreadyExistsException;
import org.openapitools.exceptions.UserDoesntExistsException;
import org.openapitools.model.*;
import org.openapitools.repository.CredentialsRepo;
import org.openapitools.repository.PlayersRepository;
import org.openapitools.repository.TeamsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class TransferPlayerApiController implements TransferPlayerApi {

    private final NativeWebRequest request;

    private PlayersRepository playersRepo = PlayersRepository.getInstance();
    private TeamsRepository teamsRepository = TeamsRepository.getInstance();
    private CredentialsRepo credRepo = CredentialsRepo.getInstance();

    private String hmacVerification(String body) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String key = "123456";
        String bodyReq = body.replace("class TransferRequest ", "");
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(bodyReq.toString().getBytes("UTF-8")));
    }

    @org.springframework.beans.factory.annotation.Autowired
    public TransferPlayerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PlayerResponse> putUpdateUserUserID(@ApiParam(value = "Id of the player", required = true) @PathVariable("playerID") String playerID,
                                                              @ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) OffsetDateTime dataTime,
                                                              @RequestHeader("Authorization") String credentials, @ApiParam(value = "id of request") @RequestHeader(value = "id", required = false) String id,
                                                              @RequestHeader("X-HMAC-SIGNATURE") String signature, @ApiParam(value = "") @Valid @RequestBody(required = false) TransferRequest body) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Player player = new Player();

        if(credRepo.areCredentialsValid(credentials)) {
            String hash = hmacVerification(body.toString());
            if(hash.equals(signature)) {
                String teamId = body.getTeamId();
                if (!playersRepo.getListOfPlayers().stream().filter(u -> u.getId().toString().equals(playerID)).findFirst().equals(Optional.empty())
                        && !teamsRepository.getListOfTeams().stream().filter(t -> t.getId().toString().equals(teamId)).findFirst().equals(Optional.empty())) {

                    player = playersRepo.getListOfPlayers().stream().filter(u -> u.getId().toString().equals(playerID)).findFirst()
                            .map(p -> new Player(p.getId().toString(), p.getFirstName(), p.getLastName(),
                                    p.getAge(), p.getHeight(), p.getNationality(), Position.PositionEnum.fromValue(p.getPosition()),
                                    p.getGoalsCount(), p.getAssistCount(), p.getYellowCardCount(), p.getRedCardCount(), p.getTeamId())).orElse(null);

                    if (!player.getTeamId().toString().equals(teamId)) {
                        player.setTeam(UUID.fromString(teamId));
                        playersRepo.updatePlayerById(UUID.fromString(playerID), new PlayerDB(UUID.fromString(playerID), player.getFirstName(), player.getLastName(),
                                player.getAge(), player.getHeight(), player.getNationality(), player.getPosition().toString(),
                                player.getGoalsCount(), player.getAssistCount(), player.getYellowCardCount(), player.getRedCardCount(), player.getTeamId()));
                    } else {
                        throw new UserAlreadyExistsException("Player is already in the team");
                    }
                } else {
                    throw new UserDoesntExistsException("Player or Team doesn't exists");
                }
            } else {
                throw new MessageNotValidException("Message is not valid! HMAC verification failed");
            }
        } else {
            throw new BadCredentialsException("Unauthorized");
        }
        return ResponseEntity.ok().body(new PlayerResponse().player(player).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));

    }
}
