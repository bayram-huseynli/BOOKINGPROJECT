package com.example.msrelations.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimSet {

    private String key;

    private Set<String> claim;
}
