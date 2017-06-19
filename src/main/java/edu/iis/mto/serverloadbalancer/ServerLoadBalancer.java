package edu.iis.mto.serverloadbalancer;

public class ServerLoadBalancer {

	public void balance(Server[] servers, Vm[] vms) {
		for (Vm vm : vms) {
			Server lessLoadedServer = null;
			addToLessLoadedServer(servers, vm, lessLoadedServer);
		}
	}

	private void addToLessLoadedServer(Server[] servers, Vm vm, Server lessLoadedServer) {
		for (Server server : servers) {
			lessLoadedServer = findLessLoadedServer(lessLoadedServer, server);
		}
		lessLoadedServer.addVm(vm);
	}

	private Server findLessLoadedServer(Server lessLoadedServer, Server server) {
		if(lessLoadedServer == null || server.currentLoadPercentage < lessLoadedServer.currentLoadPercentage) {
			lessLoadedServer = server;
		}
		return lessLoadedServer;
	}

}
