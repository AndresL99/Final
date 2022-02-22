package com.alerner.demo.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Covid19
{
    @SerializedName(value = "continent")
    private String continent;

    @SerializedName(value = "total")
    private Integer total;

    @SerializedName(value = "time")
    private LocalDateTime time;
}
