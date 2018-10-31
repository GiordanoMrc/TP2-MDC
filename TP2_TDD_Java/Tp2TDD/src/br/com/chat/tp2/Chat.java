package br.com.chat.tp2;

/**
 * Classe que � a abstra��o de um Chat. Tem m�todos e atributos que efetuam
 * a viabilidade da comunica��o entre dois chats. Tal classe foi implementada 
 * se baseando nos testes elaborados para seguir o pattern TDD.
 * 
 * @author Wellignton Stanley
 *
 */
public class Chat {
	private boolean isBusy;//indica se o chat j� est� em conex�o com outro
	private boolean received;//indica se tem mensagem recebida
	private boolean send;//representa se tem mensagem enviada
	private String receiveMessage;//indica o conte�do da mensagem recebida
	private String responseMessage;//indica o conte�do da mensagem enviada
	private Chat chat;//representa o chat de conex�o

	//construtor que configura o chat inicialmente.
	public Chat() {
		this.isBusy = false;
		this.received = false;
		this.send = false;
	}
	
	//Responsavel por atribuir a mensagem de requisi��o do chat
	public boolean sendRequest(String response) {
		this.responseMessage = response;
		this.received = false;
		this.send = true;
		return true;
	}
	
	//M�todo que recebe a mensagem e atribui o valor para a variavel do chat
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
