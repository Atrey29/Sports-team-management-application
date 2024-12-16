package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.exceptions.EmptyRepositoryException;
import org.openapitools.model.Player;
import org.openapitools.model.PlayerListResponse;
import org.openapitools.model.Position;
import org.openapitools.model.ResponseHeader;
import org.openapitools.repository.PlayersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class PlayersApiController implements PlayersApi {

    private PlayersRepository playersRepo = PlayersRepository.getInstance();
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlayersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<PlayerListResponse> getUsersUserId(@ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) OffsetDateTime dataTime, @ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id) {

        List<Player> Players = new ArrayList<Player>();

        if(!playersRepo.getListOfPlayers().isEmpty()){
            Players = playersRepo.getListOfPlayers().stream()
                    .map(p -> new Player(p.getId().toString(), p.getFirstName(), p.getLastName(), p.getAge(), p.getHeight(), p.getNationality(), Position.PositionEnum.fromValue(p.getPosition()), p.getGoalsCount(), p.getAssistCount(), p.getYellowCardCount(), p.getRedCardCount(), p.getTeamId()))
                    .collect(Collectors.toList());
        } else {
            throw new EmptyRepositoryException("Repository is empty");
        }
        return ResponseEntity.ok().body(new PlayerListResponse().playerList(Players).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }
}
