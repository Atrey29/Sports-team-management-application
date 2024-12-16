package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeamListResponse {
    @JsonProperty("responseHeader")
    private org.openapitools.model.ResponseHeader responseHeader = null;

    @JsonProperty("teamsList")
    @Valid
    private List<Team> teamsList = new ArrayList<>();

    public TeamListResponse responseHeader(org.openapitools.model.ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
        return this;
    }

    /**
     * Get responseHeader
     * @return responseHeader
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public org.openapitools.model.ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(org.openapitools.model.ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public TeamListResponse teamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
        return this;
    }

    public TeamListResponse addTeamsListItem(Team teamsListItem) {
        this.teamsList.add(teamsListItem);
        return this;
    }

    /**
     * Get teamsList
     * @return teamsList
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Team> teamsList) {
        this.teamsList = teamsList;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TeamListResponse userListResponse = (TeamListResponse) o;
        return Objects.equals(this.responseHeader, userListResponse.responseHeader) &&
                Objects.equals(this.teamsList, userListResponse.teamsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseHeader, teamsList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TeamsListResponse {\n");

        sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
        sb.append("    teamsList: ").append(toIndentedString(teamsList)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
