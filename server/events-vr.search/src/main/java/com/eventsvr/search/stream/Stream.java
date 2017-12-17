package com.eventsvr.search.stream;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "eventsvr", type = "stream")
public class Stream {
    @Id
    @JsonIgnore
    private String id;

    @Field(type = FieldType.String)
    private String name;


    @Field(type = FieldType.String)
    private String thumbnail;


    @Field(type = FieldType.String)
    private String streamer;

//    @JsonProperty("stream_type")
    private StreamType streamType;

//    @JsonProperty("viewers_count")
    private Long viewersCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStreamer() {
        return streamer;
    }

    public void setStreamer(String streamer) {
        this.streamer = streamer;
    }

    public StreamType getStreamType() {
        return streamType;
    }

    public void setStreamType(StreamType streamType) {
        this.streamType = streamType;
    }

    public Long getViewersCount() {
        return viewersCount;
    }

    public void setViewersCount(Long viewersCount) {
        this.viewersCount = viewersCount;
    }
}
