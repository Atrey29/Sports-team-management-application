package org.openapitools.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openapitools.model.Position;
import org.openapitools.model.Team;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Player
 */
@AllArgsConstructor
@NoArgsConstructor
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-12-09T21:04:10.402+01:00[Europe/Belgrade]")
public class Player   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("age")
  private Integer age;

  @JsonProperty("height")
  private Integer height;

  @JsonProperty("nationality")
  private String nationality;

  @JsonProperty("position")
  private Position.PositionEnum position;

  @JsonProperty("goalsCount")
  private Integer goalsCount;

  @JsonProperty("assistCount")
  private Integer assistCount;

  @JsonProperty("yellowCardCount")
  private Integer yellowCardCount;

  @JsonProperty("redCardCount")
  private Integer redCardCount;

  @JsonProperty("teamId")
  private UUID teamId;

  public Player id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "123e4567-e89b-42d3-a456-556642440000", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Player firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(example = "Kamil", value = "")

@Pattern(regexp = "^[A-Za-z]+") 
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Player lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(example = "Grosicki", value = "")

@Pattern(regexp = "^[A-Za-z]+") 
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Player age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * minimum: 1
   * maximum: 99
   * @return age
  */
  @ApiModelProperty(example = "23", value = "")

@Min(1) @Max(99) 
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Player height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * minimum: 0
   * maximum: 243
   * @return height
  */
  @ApiModelProperty(example = "180", value = "")

@Min(0) @Max(243) 
  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Player nationality(String nationality) {
    this.nationality = nationality;
    return this;
  }

  /**
   * Get nationality
   * @return nationality
  */
  @ApiModelProperty(example = "PL", value = "")


  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public Player position(Position.PositionEnum position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
  */
  @ApiModelProperty(value = "")

  @Valid

  public Position.PositionEnum getPosition() {
    return position;
  }

  public void setPosition(Position.PositionEnum position) {
    this.position = position;
  }

  public Player goalsCount(Integer goalsCount) {
    this.goalsCount = goalsCount;
    return this;
  }

  /**
   * Get goalsCount
   * @return goalsCount
  */
  @ApiModelProperty(example = "10", value = "")


  public Integer getGoalsCount() {
    return goalsCount;
  }

  public void setGoalsCount(Integer goalsCount) {
    this.goalsCount = goalsCount;
  }

  public Player assistCount(Integer assistCount) {
    this.assistCount = assistCount;
    return this;
  }

  /**
   * Get assistCount
   * @return assistCount
  */
  @ApiModelProperty(example = "7", value = "")


  public Integer getAssistCount() {
    return assistCount;
  }

  public void setAssistCount(Integer assistCount) {
    this.assistCount = assistCount;
  }

  public Player yellowCardCount(Integer yellowCardCount) {
    this.yellowCardCount = yellowCardCount;
    return this;
  }

  /**
   * Get yellowCardCount
   * @return yellowCardCount
  */
  @ApiModelProperty(example = "3", value = "")


  public Integer getYellowCardCount() {
    return yellowCardCount;
  }

  public void setYellowCardCount(Integer yellowCardCount) {
    this.yellowCardCount = yellowCardCount;
  }

  public Player redCardCount(Integer redCardCount) {
    this.redCardCount = redCardCount;
    return this;
  }

  /**
   * Get redCardCount
   * @return redCardCount
  */
  @ApiModelProperty(example = "1", value = "")


  public Integer getRedCardCount() {
    return redCardCount;
  }

  public void setRedCardCount(Integer redCardCount) {
    this.redCardCount = redCardCount;
  }

  public Player teamId(UUID teamId) {
    this.teamId = teamId;
    return this;
  }

  /**
   * Get team
   * @return team
  */
  @ApiModelProperty(value = "")

  @Valid

  public UUID getTeamId() {
    return teamId;
  }

  public void setTeam(UUID teamId) {
    this.teamId = teamId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(this.id, player.id) &&
        Objects.equals(this.firstName, player.firstName) &&
        Objects.equals(this.lastName, player.lastName) &&
        Objects.equals(this.age, player.age) &&
        Objects.equals(this.height, player.height) &&
        Objects.equals(this.nationality, player.nationality) &&
        Objects.equals(this.position, player.position) &&
        Objects.equals(this.goalsCount, player.goalsCount) &&
        Objects.equals(this.assistCount, player.assistCount) &&
        Objects.equals(this.yellowCardCount, player.yellowCardCount) &&
        Objects.equals(this.redCardCount, player.redCardCount) &&
        Objects.equals(this.teamId, player.teamId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, age, height, nationality, position, goalsCount, assistCount, yellowCardCount, redCardCount, teamId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    
    sb.append("    \"id\": \"").append(toIndentedString(id)).append("\",\n");
    sb.append("    \"firstName\": \"").append(toIndentedString(firstName)).append("\",\n");
    sb.append("    \"lastName\": \"").append(toIndentedString(lastName)).append("\",\n");
    sb.append("    \"age\": ").append(toIndentedString(age)).append(",\n");
    sb.append("    \"height\": ").append(toIndentedString(height)).append(",\n");
    sb.append("    \"nationality\": \"").append(toIndentedString(nationality)).append("\",\n");
    sb.append("    \"position\": \"").append(toIndentedString(position)).append("\",\n");
    sb.append("    \"goalsCount\": ").append(toIndentedString(goalsCount)).append(",\n");
    sb.append("    \"assistCount\": ").append(toIndentedString(assistCount)).append(",\n");
    sb.append("    \"yellowCardCount\": ").append(toIndentedString(yellowCardCount)).append(",\n");
    sb.append("    \"redCardCount\": ").append(toIndentedString(redCardCount)).append(",\n");
    sb.append("    \"team\": \"").append(toIndentedString(teamId)).append("\"\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

