import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class completabletestfuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> cf=CompletableFuture.runAsync(new Runnable() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				}catch(InterruptedException e){e.printStackTrace();}
				
				System.out.println("Seperate Thread");}
		});
		
		CompletableFuture<Void> cf2=CompletableFuture.runAsync(() ->{
			
				try {
					TimeUnit.SECONDS.sleep(1);
				}catch(InterruptedException e){e.printStackTrace();}
				
				System.out.println("Seperate Thread");
		});
		
		
		CompletableFuture<String> cf3=CompletableFuture.supplyAsync(() ->{
			
			try {
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException e){e.printStackTrace();}
		
			return "krishna";
	}).thenApply(name ->{return "welcome"+name;
	}).thenApply(welcome ->{return welcome +"to cogentinfotech";});
	
		
		 System.out.println(cf3.get());
		
	}
}
