package ru.fomin.hotels.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoomCategoryConvenienceId implements Serializable {
    @Column(name = "room_category_id")
    private Integer roomCategoryId;

    @Column(name = "convenience_id")
    private Integer convenienceId;
}