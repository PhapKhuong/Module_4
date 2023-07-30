package com.room.query;

public class RoomQuery {
    private RoomQuery() {
    }

    public static final String SELECT_PAGE_ROOM =
            "SELECT * FROM room INNER JOIN payment ON room.payment_id = payment.payment_id WHERE room_id LIKE :input OR room_name LIKE :input OR phone LIKE :input ORDER BY room_id";
    public static final String SELECT_LIST_ROOM =
            "SELECT * FROM room INNER JOIN payment ON room.payment_id = payment.payment_id";

}
