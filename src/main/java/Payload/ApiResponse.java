package Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
// API response method give a proper message after deleting id and check weather id is present or not according to that it pass message
	private String messaage;
	private boolean success;
	}

