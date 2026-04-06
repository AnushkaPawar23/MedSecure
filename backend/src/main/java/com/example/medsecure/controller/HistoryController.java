package com.example.medsecure.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medsecure.model.ScanHistory;
import com.example.medsecure.model.User;
import com.example.medsecure.repository.ScanHistoryRepository;
import com.example.medsecure.repository.UserRepository;
@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class HistoryController {
    @Autowired
    private ScanHistoryRepository historyRepository;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/add")
    public ResponseEntity<?> addToHistory(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
     
        try {
            Long userId = Long.parseLong(request.get("userId").toString());
            Optional<User> userOpt = userRepository.findById(userId);
         
            if (!userOpt.isPresent()) {
                response.put("success", false);
                response.put("message", "User not found");
                return ResponseEntity.badRequest().body(response);
            }
         
            User user = userOpt.get();
            String searchQuery = (String) request.get("searchQuery");
            String searchType = (String) request.get("searchType");
            String scanResult = (String) request.get("scanResult");
            String message = (String) request.get("message");
         
            ScanHistory history = new ScanHistory();
            history.setUser(user);
            history.setSearchQuery(searchQuery);
            history.setSearchType(searchType);
            history.setScanResult(scanResult);
            history.setMessage(message);
         
            historyRepository.save(history);
         
            response.put("success", true);
            response.put("message", "History saved");
         
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ScanHistory>> getUserHistory(@PathVariable Long userId) {
        List<ScanHistory> history = historyRepository.findByUserIdOrderByScannedAtDesc(userId);
        return ResponseEntity.ok(history);
    }
    @DeleteMapping("/user/{userId}")
public ResponseEntity<?> deleteUserHistory(@PathVariable Long userId) {
    Map<String, Object> response = new HashMap<>();
    try {
        List<ScanHistory> history = historyRepository.findByUserIdOrderByScannedAtDesc(userId);
        if (history.isEmpty()) {
            response.put("success", false);
            response.put("message", "No history found for this user");
            return ResponseEntity.ok(response);
        }
        historyRepository.deleteAll(history);
        response.put("success", true);
        response.put("message", "History cleared successfully");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        response.put("success", false);
        response.put("message", "Error: " + e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
}