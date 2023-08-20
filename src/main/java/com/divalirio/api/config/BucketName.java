package com.divalirio.api.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
    TODO_IMAGE("divalirio-bucket");
    private final String bucketName;
}
