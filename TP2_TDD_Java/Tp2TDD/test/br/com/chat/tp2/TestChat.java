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
 * Suite que é responsável por armazenar os cenários e casos de testes relacionados 
 * a um chat para conversas de duas conexões. Esta implementação se baseia nas 
 * recomendações e especificações do padrão TDD, ou seja, o direcionamento das 
 * funcionalidades é em relação aos testes. Logo, o teste é elaborado para posteriormente
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
		System.out.println("#######Suíte de testes iniciada.########");
	}
	
	//executado apenas uma vez depois de tudo dentro da suíte. Exibe o aviso final
	@AfterAll
	public static void tearDown() {
		System.out.println("#######Suíte de testes finalizada.########");
	}

	/**
	 * É executado antes de cada cenário de teste. Inicializa variáveis e efetua
	 * configurações necessárias para o teste seguinte.
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
	 * É executado depois de cada cenário de teste. Reseta as variáveis e
	 * configurações necessárias para o teste seguinte.
	 * 
	 * @return void
	 */
	@AfterEach
	public void finalize() {
		chat = null;
		chat2 = null;
	}
	
	/**
	 * Método que testa o conteúdo de mensagem que será enviada. O teste passa se a mensagem 
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
	 * Método que testa se a mensagem foi recebida e o seu conteúdo. O teste passa se duas 
	 * condições são satisfeitas: <p> 1 - se a mensagem esperada for igual a atual, neste caso, "Hi";<br>
	 * 2 - se o status de recebido é true.
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
	 * Teste responsável por validar a comunicação de envio efetivo de uma mensagem de um emissor 
	 * para um receptor, neste caso, de um chat para outro chat2. O teste passa se duas quatro
	 * condições são satisfeitas: <p> 1 - se a mensagem esperada, que foi recebida pelo chat2, for igual a atual, neste caso, "Hello";<br>
	 * 2 - se o status de recebido do chat2 é true;<br>
	 * 3 - se a mensagem esperada, que foi enviada pelo chat, for igual a atual, neste caso, "Hello";<br>
	 * 4 - se o status de enviado do chat é true.<br>
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
