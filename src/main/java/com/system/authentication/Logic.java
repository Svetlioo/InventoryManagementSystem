package com.system.authentication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Logic {
    private static final ArrayList<Role> users = new ArrayList<>();
    private Role currentUser;

    public static void loadUserProfiles() {
        users.clear();
        try {
            File jsonFile = new File("src/main/java/com/system/authentication/users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(jsonFile);
            JsonNode usersArray = jsonData.get("users");
            for (JsonNode user : usersArray) {
                users.add(new UserImp(user.get("username").asText(), user.get("password").asText()) {
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String registerUser(String username, String password) {
        boolean isNotRegistered = true;
        for (Role user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isNotRegistered = false;
                break;
            }
            if (user.getUsername().equals(username) && !user.getPassword().equals(password)) {
                return "Username already in use";
            }
        }
        if (isNotRegistered) {
            User user = new UserImp(username, password);
            users.add(user);
            saveUserProfile(user);
            return "Registered successfully";
        }
        return "Already registered";
    }

    public static void saveUserProfile(User user) {
        try {
            File jsonFile = new File("src/main/java/com/system/authentication/users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonData = objectMapper.readValue(jsonFile, ObjectNode.class);
            ArrayNode usersArray = (ArrayNode) jsonData.get("users");
            if (usersArray == null) {
                usersArray = objectMapper.createArrayNode();
                jsonData.set("users", usersArray);
            }
            ObjectNode userNode = objectMapper.createObjectNode();
            userNode.put("username", user.getUsername());
            userNode.put("password", user.getPassword());
            usersArray.add(userNode);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Role loginUser(String username, String password) {
        for (Role user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }


}


