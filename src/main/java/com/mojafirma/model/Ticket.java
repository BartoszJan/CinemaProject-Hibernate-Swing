package com.mojafirma.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "ticket")

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticket_id;

    @ManyToOne
    @JoinColumn(name = "showing_id", nullable = false)
    private Showing showing;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_last_name")
    private String user_last_name;

    @Column(name = "seat")
    private int seat;

        public int getTicket_id() {
            return ticket_id;
        }

        public void setTicket_id(int ticket_id) {
            this.ticket_id = ticket_id;
        }

        public Showing getShowing() {
            return showing;
        }

        public void setShowing(Showing showing) {
            this.showing = showing;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_last_name() {
            return user_last_name;
        }

        public void setUser_last_name(String user_last_name) {
            this.user_last_name = user_last_name;
        }

        public int getSeat() {
            return seat;
        }

        public void setSeat(int seat) {
            this.seat = seat;
        }

        @Override
        public String toString() {
            return "Showing{" +
                    "ticket_id=" + ticket_id +
                    ", showing=" + showing +
                    ", user_name='" + user_name + '\'' +
                    ", user_last_name='" + user_last_name + '\'' +
                    ", seats=" + seat +
                    '}';
        }
}

