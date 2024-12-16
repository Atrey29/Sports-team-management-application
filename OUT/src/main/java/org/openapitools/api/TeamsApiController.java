package org.openapitools.api;

import io.swagger.annotations.ApiParam;
import org.openapitools.exceptions.EmptyRepositoryException;
import org.openapitools.model.*;
import org.openapitools.repository.TeamsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-05T13:43:41.484+01:00[Europe/Belgrade]")
@Controller
@RequestMapping("${openapi.userCRUD.base-path:}")
public class TeamsApiController implements TeamsApi {

    private final NativeWebRequest request;

    private TeamsRepository teamsRepo = TeamsRepository.getInstance();

    @org.springframework.beans.factory.annotation.Autowired
    public TeamsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<TeamListResponse> getTeams(
            @ApiParam(value = "data-time of request") @RequestHeader(value = "Data-time", required = false) String dataTime
            ,
            @ApiParam(value = "id of request") @RequestHeader(value = "Id", required = false) String id
    ) {

        List<Team> Teams = new ArrayList<Team>();

        if(!teamsRepo.getListOfTeams().isEmpty()){
            Teams = teamsRepo.getListOfTeams().stream()
                    .map(p -> new Team(p.getId().toString(), p.getName()))
                    .collect(Collectors.toList());

        } else {
            throw new EmptyRepositoryException("Repository is empty");
        }
        return ResponseEntity.ok().body(new TeamListResponse().teamsList(Teams).
                responseHeader(new ResponseHeader().requestId(UUID.randomUUID()).sendDate(new Date(System.currentTimeMillis()))));
    }

}
