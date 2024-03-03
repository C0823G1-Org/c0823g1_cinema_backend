package com.example.c0823g1_movie_backend.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    @NotBlank(message = "Tên phim không được để rỗng")
    @Size(min = 1,max = 100,message = "Tên phim có độ dài từ 1 đến 100 ký tự")
    private String name;
    @NotNull(message = "Ngày bắt đầu chiếu phim không được để rỗng")
    private LocalDate startDate;
    @NotBlank(message = "Tên diễn viên không được để rỗng")
    @Size(min = 1,max = 200,message = "Tên diễn viên có độ dài từ 1 đến 200 ký tự")
    private String actor;
    @NotBlank(message = "Tên đạo diễn không được để rỗng")
    @Size(min = 1,max = 100,message = "Tên đạo diễn có độ dài từ 1 đến 100 ký tự")
    private String director;
    @NotBlank(message = "Tên nhà phát hành không được để rỗng")
    @Size(min = 1,max = 100,message = "Tên nhà phát hành có độ dài từ 1 đến 100 ký tự")
    private String publisher;
    @NotNull(message = "Thời lượng phim không được để rỗng")
    @Min(value = 1, message = "Thời lượng phim phải lớn hơn 0")
    private Integer duration;
    @NotBlank(message = "Trailer phim không được để rỗng")
    private String trailer;
    @NotBlank(message = "Quốc gia sản xuất phim không được để rỗng")
    @Size(min = 1,max = 40,message = "Tên quốc gia có độ dài từ 1 đến 40 ký tự")
    private String country;
    private String description;
    @NotBlank(message = "Poster phim không được để rỗng")
    private String poster;
    private Integer ticketPrice;

    public MovieDTO(String name, LocalDate startDate, String actor, String director, String publisher, Integer duration
            , String trailer, String country, String description, String poster, Integer ticketPrice) {
        this.name = name;
        this.startDate = startDate;
        this.actor = actor;
        this.director = director;
        this.publisher = publisher;
        this.duration = duration;
        this.trailer = trailer;
        this.country = country;
        this.description = description;
        this.poster = poster;
        this.ticketPrice = ticketPrice;
    }
}
