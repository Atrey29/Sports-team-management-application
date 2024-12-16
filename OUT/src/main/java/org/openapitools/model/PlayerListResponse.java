package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ResponseHeader;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerListResponse {
    @JsonProperty("responseHeader")
    private org.openapitools.model.ResponseHeader responseHeader = null;

    @JsonProperty("usersList")
    @Valid
    private List<Player> playerList = new ArrayList<>();

    public PlayerListResponse responseHeader(org.openapitools.model.ResponseHeader responseHeader) {
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

    public PlayerListResponse playerList(List<Player> playerList) {
        this.playerList = playerList;
        return this;
    }

    public PlayerListResponse addUsersListItem(Player playerListItem) {
        this.playerList.add(playerListItem);
        return this;
    }

    /**
     * Get playerList
     * @return playersList
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerListResponse playerListResponse = (PlayerListResponse) o;
        return Objects.equals(this.responseHeader, playerListResponse.responseHeader) &&
                Objects.equals(this.playerList, playerListResponse.playerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseHeader, playerList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PlayerListResponse {\n");

        sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
        sb.append("    playerList: ").append(toIndentedString(playerList)).append("\n");
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
