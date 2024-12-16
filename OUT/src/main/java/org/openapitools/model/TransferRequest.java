package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TransferRequest {
    @JsonProperty("requestHeader")
    private io.swagger.model.RequestHeader requestHeader = null;

    @JsonProperty("teamId")
    private String teamId = null;

    public TransferRequest requestHeader(io.swagger.model.RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
        return this;
    }

    /**
     * Get requestHeader
     * @return requestHeader
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public io.swagger.model.RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(io.swagger.model.RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public TransferRequest teamId(String teamId) {
        this.teamId = teamId;
        return this;
    }

    /**
     * Get teamId
     * @return teamId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransferRequest updateRequest = (TransferRequest) o;
        return Objects.equals(this.requestHeader, updateRequest.requestHeader) &&
                Objects.equals(this.teamId, updateRequest.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestHeader, teamId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransferRequest {\n");

        sb.append("    \"teamId\": \"").append(toIndentedString(teamId)).append("\"\n");
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
