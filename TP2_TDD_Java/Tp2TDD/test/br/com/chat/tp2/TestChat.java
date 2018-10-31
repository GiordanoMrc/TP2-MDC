package br.com.chat.tp2;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * Suite que � respons�vel por armazenar os cen�rios e casos de testes relacionados 
 * a um chat para conversas de duas conex�es. Esta implementa��o se baseia nas 
 * recomenda��es e especifica��es do padr�o TDD, ou seja, o direcionamento das 
 * funcionalidades � em rela��o aos testes. Logo, o teste � elaborado para posteriormente
 * a funcionalidade ser implementada a fim de satisfazer este teste.
 * 
 * @author Wellington Stanley
 *
 */
@SuiteClasses(value = { TestChat.class })
public class TestChat {

	public Chat chat,chat2;
	
	//executado apenas uma vez e antes de qualquer outra funcao existente. Exibe o aviso inicial
	@BeforeAll
	public static void initTests() {
		System.out.println("#######Su�te de testes iniciada.########");
	}
	
	//executado apenas uma vez depois de tudo dentro da su�te. Exibe o aviso final
	@AfterAll
	public static void tearDown() {
		System.out.println("#######Su�te de testes finalizada.########");
	}

	/**
	 * � executado antes de cada cen�rio de teste. Inicializa vari�veis e efetua
	 * configura��es necess�rias para o teste seguinte.
	 * 
	 * @return void
	 */
	@BeforeEach
	public void initialize() {
		chat = new Chat();
		chat2 = new Chat();
		chat.setChat(chat2);
		chat2.setChat(chat);
		System.out.println("#######EXECUTANDO########");
	}
	
	/**
	 * � executado depois de cada cen�rio de teste. Reseta as vari�veis e
	 * configura��es necess�rias para o teste seguinte.
	 * 
	 * @return void
	 */
	@AfterEach
	public void finalize() {
		chat = null;
		chat2 = null;
	}
	
	/**
	 * M�todo que testa o conte�do de mensagem que ser� enviada. O teste passa se a mensagem 
	 * esperada for igual atual, neste caso, "Hi".
	 * 
	 * @return void
	 */
	@Test
	public void testMessage() {
		chat.sendRequest("Hi");
		String message = chat.getResponseMessage();
		
		assertEquals(null, "Hi", message);
	}

	/**
	 * M�todo que testa se a mensagem foi recebida e o seu conte�do. O teste passa se duas 
	 * condi��es s�o satisfeitas: <p> 1 - se a mensagem esperada for igual a atual, neste caso, "Hi";<br>
	 * 2 - se o status de recebido � true.
	 * 
	 * @return void
	 */
	@Test
	void testReceiveMessage() {
		chat.receiveMessage("Hi");
		boolean received = chat.isReceived();
		
		assertEquals(null, "Hi", chat.getReceiveMessage());
		assertEquals(true, received);
	}
	
	/**
	 * Teste respons�vel por validar a comunica��o de envio efetivo de uma mensagem de um emissor 
	 * para um receptor, neste caso, de um chat para outro chat2. O teste passa se duas quatro
	 * condi��es s�o satisfeitas: <p> 1 - se a mensagem esperada, que foi recebida pelo chat2, for igual a atual, neste caso, "Hello";<br>
	 * 2 - se o status de recebido do chat2 � true;<br>
	 * 3 - se a mensagem esperada, que foi enviada pelo chat, for igual a atual, neste caso, "Hello";<br>
	 * 4 - se o status de enviado do chat � true.<br>
	 * 
	 * @return void
	 */
	@Test
	void testResponseMessage() {
		chat.setResponseMessage("Hello");
		chat.getChat().receiveMessage(chat.getResponseMessage());
		
		assertEquals(null, "Hello", chat2.getReceiveMessage());
		assertEquals(true , chat2.isReceived());
		assertEquals(null, "Hello", chat.getResponseMessage());
		assertEquals(false, chat.isSend());
		
	}

}
