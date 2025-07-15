package ru.fomin.hotels.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room_category_conveniences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomCategoryConvenience {
    @EmbeddedId
    private RoomCategoryConvenienceId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roomCategoryId")
    @JoinColumn(name = "room_category_id")
    private RoomCategory roomCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("convenienceId")
    @JoinColumn(name = "convenience_id")
    private Convenience convenience;
}