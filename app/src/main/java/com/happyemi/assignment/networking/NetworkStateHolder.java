package com.happyemi.assignment.networking;
/**
 * <h2>NetworkStateHolder</h2>
 * <P>
 *   it is holder class for the network service class
 *   data provider to carry the network info from the required class.
 * </P>
 * @version 1.0.
 * @author 3Embed.
 * */
public class NetworkStateHolder
{
    private String message;
    private boolean isConnected;
    private ConnectionType connectionType;

    public ConnectionType getConnectionType()
    {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType)
    {
        this.connectionType = connectionType;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public boolean isConnected()
    {
        return isConnected;
    }
    public void setConnected(boolean connected)
    {
        isConnected = connected;
    }
}
