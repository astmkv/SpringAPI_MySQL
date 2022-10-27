package com.example.demo.db;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Request {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer id;
        private String name;
        private String email;

        public String getPh_number() {
            return ph_number;
        }

        public void setPh_number(String ph_number) {
            this.ph_number = ph_number;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        private String ph_number;

        private String adress;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return id + " - " + name;
        }
    }
