package io.scalability.assignment.videosharingdemo.domain;


import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
@Data
public class User{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    
        @Column(unique = true)
        private String username;

        @Column
        private int password;
    
        // @Lob
        // private byte[] data;
    
        public User(String username, int password) {
            this.username = username;
            this.password = password;
            // this.data = data;
        }
        // No-argument constructor explicitly defined (for Hibernate)
        public User() {
            // No need to do anything here
        }

        public String getUsername() {
            return username;
        }

        public int getPassword() {
            return password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(int password) {
            this.password = password;
        }
}
