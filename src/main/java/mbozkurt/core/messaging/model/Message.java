package mbozkurt.core.messaging.model;

/**
 * 
 * 
 * Hata (Error): Uygulamanın çalışmasını engelleyen, kullanıcıyı durduran ciddi
 * problemleri ifade eder. Örneğin, bir sunucu hatası, doğrulama hatası veya
 * kritik bir işlevselliğin başarısız olması bir hatadır.
 * 
 * Uyarı (Warning): Kullanıcının dikkat etmesi gereken ancak işleyişi
 * durdurmayan daha hafif durumlar. Örneğin, eksik bir alan veya önerilen ama
 * zorunlu olmayan bir ayar bir uyarıdır.
 * 
 * Hatalar: Net ve doğrudan olmalı. Kullanıcıya neyin yanlış gittiğini ve nasıl
 * düzeltebileceğini söylemelidir.
 * 
 * Örneğin:
 * 
 * Email is required.
 * 
 * Password must contain at least one special character.
 * 
 * 
 * Uyarılar: Daha yumuşak bir dil kullanarak, kullanıcının dikkatini çekmeli ama
 * onu durdurmamalıdır.
 * 
 * Örneğin:
 * 
 * It's recommended to upload a profile picture.
 * 
 * Your password is too simple, consider making it stronger.
 * 
 * 
 */
public interface Message {

	String getCode();
	
//	String getText();

	MessageType getType();
}
