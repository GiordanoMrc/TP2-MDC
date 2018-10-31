package br.com.chat.tp2;

/**
 * Classe que é a abstração de um Chat. Tem métodos e atributos que efetuam
 * a viabilidade da comunicação entre dois chats. Tal classe foi implementada 
 * se baseando nos testes elaborados para seguir o pattern TDD.
 * 
 * @author Wellignton Stanley
 *
 */
public class Chat {
	private boolean isBusy;//indica se o chat já está em conexão com outro
	private boolean received;//indica se tem mensagem recebida
	private boolean send;//representa se tem mensagem enviada
	private String receiveMessage;//indica o conteúdo da mensagem recebida
	private String responseMessage;//indica o conteúdo da mensagem enviada
	private Chat chat;//representa o chat de conexão

	//construtor que configura o chat inicialmente.
	public Chat() {
		this.isBusy = false;
		this.received = false;
		this.send = false;
	}
	
	//Responsavel por atribuir a mensagem de requisição do chat
	public boolean sendRequest(String response) {
		this.responseMessage = response;
		this.received = false;
		this.send = true;
		return true;
	}
	
	//Método que recebe a mensagem e atribui o valor para a variavel do chat
	public void receiveMessage(String receiveMessage) {
		this.receiveMessage = receiveMessage;
		this.received = true;
		this.send = false;
	}
	
	//Efetua o envio de uma mensagem para o outro chat. Aciona o metodo de recebimento do outro chat.
	public void sendResponse(String request) {
		chat.receiveMessage(request);
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public boolean isBusy() {
		return isBusy;
	}
	
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
	public boolean isReceived() {
		return received;
	}
	
	public void setReceived(boolean received) {
		this.received = received;
	}
	
	public String getReceiveMessage() {
		return receiveMessage;
	}
	
	public void setReceiveMessage(String receiveMessage) {
		this.receiveMessage = receiveMessage;
	}
	
	public Chat getChat() {
		return chat;
	}
	
	public void setChat(Chat chat) {
		this.isBusy = true;
		this.chat = chat;
	}
	
	public boolean isSend() {
		return send;
	}
	
	public void setSend(boolean send) {
		this.send = send;
	}
}
