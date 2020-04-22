package com.jy.study.spring.websocket.study.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@ConfigurationProperties("application.websocket.session")
public class AppProperties {

    private String endPoint = "websocket";

    private String allowedOrigin = "*";

    private String destinationPrefix = "/topic";

    private String userDestinationPrefix = "/user";

    private String applicationDestinationPrefix = "/app";

    private String ticketKey = "ticket";

    private Set<String> anonymousTopicSet = new HashSet<>();

    private long serverHeartBeatFrequency = 10000;

    private long clientHeartBeatFrequency = 0;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }

    public String getDestinationPrefix() {
        return destinationPrefix;
    }

    public void setDestinationPrefix(String destinationPrefix) {
        this.destinationPrefix = destinationPrefix;
    }

    public String getUserDestinationPrefix() {
        return userDestinationPrefix;
    }

    public void setUserDestinationPrefix(String userDestinationPrefix) {
        this.userDestinationPrefix = userDestinationPrefix;
    }

    public String getApplicationDestinationPrefix() {
        return applicationDestinationPrefix;
    }

    public void setApplicationDestinationPrefix(String applicationDestinationPrefix) {
        this.applicationDestinationPrefix = applicationDestinationPrefix;
    }

    public String getTicketKey() {
        return ticketKey;
    }

    public void setTicketKey(String ticketKey) {
        this.ticketKey = ticketKey;
    }

    public long getServerHeartBeatFrequency() {
        return serverHeartBeatFrequency;
    }

    public void setServerHeartBeatFrequency(long serverHeartBeatFrequency) {
        this.serverHeartBeatFrequency = serverHeartBeatFrequency;
    }

    public long getClientHeartBeatFrequency() {
        return clientHeartBeatFrequency;
    }

    public void setClientHeartBeatFrequency(long clientHeartBeatFrequency) {
        this.clientHeartBeatFrequency = clientHeartBeatFrequency;
    }

    public Set<String> getAnonymousTopicSet() {
        return anonymousTopicSet;
    }

    public void setAnonymousTopicSet(Set<String> anonymousTopicSet) {
        this.anonymousTopicSet = anonymousTopicSet;
    }

    public String getUserErrorTopic() {
        return userDestinationPrefix + destinationPrefix + "/error";
    }

    public String getBroadcastTopic() {
        return destinationPrefix + "/broadcast";
    }

    // add ["/user/topic/error", "/topic/broadcast"]
    @PostConstruct
    public void afterPropertySet() {
        anonymousTopicSet.add(getUserErrorTopic());
        anonymousTopicSet.add(getBroadcastTopic());
    }
}
