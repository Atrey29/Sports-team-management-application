package io.swagger.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RequestHeader
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-03T14:51:48.664+01:00")

public class RequestHeader   {
    @JsonProperty("requestId")
    private UUID requestId = null;

    @JsonProperty("sendDate")
    private Date sendDate = null;

    public RequestHeader requestId(UUID requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get requestId
     * @return requestId
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public RequestHeader sendDate(Date sendDate) {
        this.sendDate = sendDate;
        return this;
    }

    /**
     * Date format according to ISO_8601 for example: yyyy-MM-dd'T'HH:mm:ss.SSSZ
     * @return sendDate
     **/
    @ApiModelProperty(example = "2020-11-17T12:08:56.235-0100", required = true, value = "Date format according to ISO_8601 for example: yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @NotNull

    @Valid

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestHeader requestHeader = (RequestHeader) o;
        return Objects.equals(this.requestId, requestHeader.requestId) &&
                Objects.equals(this.sendDate, requestHeader.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, sendDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestHeader {\n");

        sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
        sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
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

