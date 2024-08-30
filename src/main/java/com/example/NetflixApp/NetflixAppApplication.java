package com.example.NetflixApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.NetflixApp.views.LoginMenu;
import static com.example.NetflixApp.util.LoadingBar.printLoadingBar;

@SpringBootApplication
public class NetflixAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixAppApplication.class, args);

		int totalSteps = 50;
		int sleepTime = 100;

		System.out.println("Loading...");

		for (int i = 0; i <= totalSteps; i++) {
			printLoadingBar(i, totalSteps);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\nLoading Complete!");



		LoginMenu.show();
	}

}





