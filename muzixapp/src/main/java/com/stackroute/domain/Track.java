package com.stackroute.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    //need to be discussed
@ApiModel(description = "All details about the Track. ")
public class Track {
    @Id
    @ApiModelProperty(notes = "The database generated track ID")
    private int id;
    @Field
    @ApiModelProperty(notes = "The name of track")
    private String name;
    @Field
    @ApiModelProperty(notes = "The comment about track")
    private String comment;
}
