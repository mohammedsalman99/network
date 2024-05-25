package com.net1.tcpchat;

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.sql.*;
import java.text.*;

public class TCPChat extends javax.swing.JFrame {
    
    private Socket clientSocket;
    private DatagramSocket socket;
    private boolean running;
    private DefaultListModel onlineUsersModel = new DefaultListModel();
    private DefaultListModel<String> messagesModel = new DefaultListModel<>();
    private ArrayList<String> userNames = new ArrayList<>();
    private String selectedUser = new String();
    
    public TCPChat() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public TCPChat(TCPChat chat) {
        initComponents();
        setLocationRelativeTo(chat);
        chat.dispose();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        connectPanel = new javax.swing.JPanel();
        tcpServerPortField = new javax.swing.JTextField();
        localIpLabel = new javax.swing.JLabel();
        localPortLabel = new javax.swing.JLabel();
        localPortField = new javax.swing.JTextField();
        tcpServerIpLabel = new javax.swing.JLabel();
        tcpServerPortLabel = new javax.swing.JLabel();
        tcpServerIpField = new javax.swing.JTextField();
        localIpField = new javax.swing.JTextField();
        remoteIpLabel = new javax.swing.JLabel();
        remotePortLabel = new javax.swing.JLabel();
        remoteIpField = new javax.swing.JTextField();
        remotePortField = new javax.swing.JTextField();
        testButton = new javax.swing.JButton();
        onlineListScrollPane = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList<>();
        statusField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        onlineUsersLabel = new javax.swing.JLabel();
        toAllButton = new javax.swing.JButton();
        loggingAreaScrollPane = new javax.swing.JScrollPane();
        loggingArea = new javax.swing.JList<>(messagesModel);
        loginButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        sendingAreaScrollPane = new javax.swing.JScrollPane();
        sendingArea = new javax.swing.JTextArea();
        statusLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TCP Chat");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        userNameLabel.setText("Username:");

        userNameField.setNextFocusableComponent(passwordField);
        userNameField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }
        });

        passwordLabel.setText("Password:");

        tcpServerPortField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }
        });

        localIpLabel.setText("Local IP:");

        localPortLabel.setText("Local Port:");

        localPortField.setNextFocusableComponent(loginButton);
        localPortField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
                updateTestButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
                updateTestButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
                updateTestButtonState();
            }
        });

        tcpServerIpLabel.setText("TCP Server IP:");

        tcpServerPortLabel.setText("TCP Server Port:");

        tcpServerIpField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
            }
        });

        localIpField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
                updateTestButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
                updateTestButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateLoginButtonState();
                updateTestButtonState();
            }
        });

        remoteIpLabel.setText("Remote IP:");

        remotePortLabel.setText("Remote Port:");

        remoteIpField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateTestButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateTestButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateTestButtonState();
            }
        });
        remoteIpField.setEditable(false);
        remoteIpField.setText("Select a user from the list");

        remotePortField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateTestButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateTestButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateTestButtonState();
            }
        });
        remotePortField.setEditable(false);
        remotePortField.setText("Select a user from the list");

        testButton.setText("Test Connection");
        testButton.setEnabled(false);
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout connectPanelLayout = new javax.swing.GroupLayout(connectPanel);
        connectPanel.setLayout(connectPanelLayout);
        connectPanelLayout.setHorizontalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tcpServerIpLabel)
                            .addComponent(tcpServerPortLabel))
                        .addGap(18, 18, 18)
                        .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tcpServerIpField)
                            .addComponent(tcpServerPortField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(connectPanelLayout.createSequentialGroup()
                        .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(localIpLabel)
                            .addComponent(localPortLabel)
                            .addComponent(remoteIpLabel)
                            .addComponent(remotePortLabel))
                        .addGap(33, 33, 33)
                        .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(remoteIpField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(localPortField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(localIpField)
                            .addComponent(remotePortField))))
                .addContainerGap())
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(testButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        connectPanelLayout.setVerticalGroup(
            connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcpServerIpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcpServerIpLabel))
                .addGap(18, 18, 18)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcpServerPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tcpServerPortLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localIpLabel)
                    .addComponent(localIpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localPortLabel))
                .addGap(20, 20, 20)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remoteIpLabel)
                    .addComponent(remoteIpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(connectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remotePortLabel)
                    .addComponent(remotePortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(testButton)
                .addGap(25, 25, 25))
        );

        onlineList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        onlineList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onlineListMouseClicked(evt);
            }
        });
        onlineList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onlineListValueChanged(evt);
            }
        });
        onlineListScrollPane.setViewportView(onlineList);

        statusField.setEditable(false);

        sendButton.setText("Send");
        sendButton.setEnabled(false);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        onlineUsersLabel.setText("Online Users:");

        toAllButton.setText("Send to All Users");
        toAllButton.setEnabled(false);
        toAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toAllButtonActionPerformed(evt);
            }
        });

        loggingArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        loggingArea.setToolTipText("");
        loggingAreaScrollPane.setViewportView(loggingArea);

        loginButton.setText("Login");
        loginButton.setEnabled(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.setNextFocusableComponent(sendingArea);

        logoutButton.setText("Logout");
        logoutButton.setEnabled(false);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        sendingArea.setColumns(20);
        sendingArea.setForeground(java.awt.Color.gray);
        sendingArea.setRows(5);
        sendingArea.setText("Enter Text Here");
        sendingArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sendingAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sendingAreaFocusLost(evt);
            }
        });
        sendingArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateSendButtonState();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateSendButtonState();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateSendButtonState();
            }
        });
        sendingAreaScrollPane.setViewportView(sendingArea);

        statusLabel.setText("Status:");

        passwordField.setNextFocusableComponent(tcpServerIpField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel)
                        .addGap(18, 18, 18)
                        .addComponent(statusField))
                    .addComponent(sendingAreaScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(passwordField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(loggingAreaScrollPane))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(toAllButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(sendButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onlineUsersLabel)
                    .addComponent(onlineListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(onlineUsersLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(onlineListScrollPane))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(connectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(sendButton)
                                .addGap(18, 18, 18)
                                .addComponent(toAllButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(userNameLabel)
                                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(loginButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordLabel)
                                    .addComponent(logoutButton)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(loggingAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(sendingAreaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusLabel)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (userNameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()
            || tcpServerIpField.getText().trim().isEmpty() || tcpServerPortField.getText().trim().isEmpty()
            || localPortField.getText().trim().isEmpty() || localIpField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Empty Fields!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (tcpServerPortField.getText().equals(localPortField.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Invalid Ports!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int sourcePort = Integer.parseInt(localPortField.getText());
            int serverPort = Integer.parseInt(tcpServerPortField.getText());

            try {
                socket = new DatagramSocket(sourcePort);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Connection Failed! Please Try Another Port.", "Error", JOptionPane.ERROR_MESSAGE);
                statusField.setText("Connection Failed! Please Try Another Port.");
            }

            new Thread(() -> {
                running = true;
                while (running) {
                    try {
                        byte[] receivedData = new byte[2048];
                        DatagramPacket packet = new DatagramPacket(receivedData, receivedData.length);
                        socket.receive(packet);
                        String message = new String(packet.getData());
                        messagesModel.addElement(message);
                        userNames.add(message.split(" ")[2]);
                        updateLoggingArea();
                        statusField.setText("Received from IP = " + packet.getAddress().toString().split("/")[1] + ", Port = " + packet.getPort());

                    } catch (Exception e) {
                        break;
                    }
                }
            }).start();

            try {
                InetAddress sourceIP = InetAddress.getByName(localIpField.getText());
                InetAddress serverIP = InetAddress.getByName(tcpServerIpField.getText());
                clientSocket = new Socket(serverIP, serverPort, sourceIP, sourcePort);

                String command = "login";
                String pass = "#Password#";
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                outToServer.writeBytes(command + userNameField.getText() + pass + new String(passwordField.getPassword()) + '\n');

                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String response = inFromServer.readLine();

                if (response.equals("invalid")) {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
                    clientSocket.close();
                    running = false;
                    socket.close();
                } else {
                    logoutButton.setEnabled(true);
                    loginButton.setEnabled(false);
                    statusField.setText("Logged in by " + userNameField.getText() + ".");
                    
                    new Thread(() -> {
                        while (running) {
                            try {
                                String[] receivedFromServer = inFromServer.readLine().split(":");
                                if (receivedFromServer[0].equalsIgnoreCase("online")) {
                                    onlineUsersModel.removeAllElements();
                                    String[] list = receivedFromServer[1].split("-");
                                    for (int i = 0; i < list.length; i++) {
                                        onlineUsersModel.addElement(list[i]);
                                    }
                                    onlineList.setModel(onlineUsersModel);
                                } else if (receivedFromServer[0].equalsIgnoreCase("offline")) {
                                    onlineUsersModel.remove(Integer.parseInt(receivedFromServer[2]));
                                    onlineList.setModel(onlineUsersModel);

                                } else if (receivedFromServer[0].equalsIgnoreCase("kill")) {
                                    clientSocket.close();
                                    running = false;
                                    socket.close();
                                    new TCPChat(this);
                                    break;

                                } else if (receivedFromServer[0].equalsIgnoreCase("serverOffline")) {
                                    JOptionPane.showMessageDialog(this, "Server Offline!", "Error", JOptionPane.ERROR_MESSAGE);
                                    clientSocket.close();
                                    running = false;
                                    socket.close();
                                    new TCPChat(this);
                                    break;
                                }
                            } catch (Exception ex) {
                                break;
                            }
                        }
                    }).start();
                }
            } catch (IOException ex) {
                socket.close();
                JOptionPane.showMessageDialog(this, "Connection Failed! Please Try Another Port.", "Error", JOptionPane.ERROR_MESSAGE);
                statusField.setText("Connection Failed! Please Try Another Port.");
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try {
            if (clientSocket != null){
                String command = "logout";
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                outToServer.writeBytes(command + '\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        if (localIpField.getText().trim().isEmpty() || localPortField.getText().trim().isEmpty()
            || remoteIpField.getText().trim().isEmpty() || remotePortField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "You should enter all of text fields including "
                    + "Server IP & Port, Local IP & Port, Remote IP & Port", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i < onlineList.getModel().getSize(); i++) {
            String selectedItem = (String) onlineList.getModel().getElementAt(i);
            String[] info = selectedItem.split(", ");

            if (Integer.parseInt(info[1]) == Integer.parseInt(remotePortField.getText()) && info[0].equalsIgnoreCase(remoteIpField.getText())) {
                JOptionPane.showMessageDialog(rootPane, "The required fields are all correct and the connection can be established");
                break;
            } else {
                if (i == onlineList.getModel().getSize() - 1) {
                    JOptionPane.showMessageDialog(rootPane, "The required fields aren't all correct and the connection can't be established"
                            + ", Maybe the user you are trying to contact is offline"
                    );
                }

            }
        }
    }//GEN-LAST:event_testButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        if (sendingArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a Message.");
        } else {
            for (int i = 0; i < onlineList.getModel().getSize(); i++) {
                String selectedItem = (String) onlineList.getModel().getElementAt(i);
                String[] info = selectedItem.split(", ");

                if (Integer.parseInt(info[1]) == Integer.parseInt(remotePortField.getText()) && info[0].equalsIgnoreCase(remoteIpField.getText())) {
                    try {
                        int destPort = Integer.parseInt(remotePortField.getText());
                        InetAddress destIP = InetAddress.getByName(remoteIpField.getText());
                        String username = userNameField.getText();
                        String dataMessage = sendingArea.getText();

                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);
                        String finalMessage = time + " " + username + ": " + dataMessage;

                        messagesModel.addElement(time + " Me: " + dataMessage);
                        userNames.add(username + ":");
                        updateLoggingArea();
                        sendingArea.setText("");
                        sendData(destIP, destPort, finalMessage);

                        String command = "/print ";
                        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                        outToServer.writeBytes(command + time + " " + userNameField.getText() + ": " + dataMessage + "\n");

                    } catch (UnknownHostException ex) {
                        ex.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                } else {
                    if (i == onlineList.getModel().getSize() - 1) {
                        JOptionPane.showMessageDialog(rootPane, "The host you're trying to send a msg to isn't online or didn't login");
                    }

                }
            }
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void toAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toAllButtonActionPerformed
        boolean sendToServer = true;
        if (sendingArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a Message.");
        } else {
            String username = userNameField.getText();
            String dataMessage = sendingArea.getText();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp);

            messagesModel.addElement(time + " Me: " + dataMessage);
            userNames.add(username + ":");
            updateLoggingArea();

            for (int i = 0; i < onlineList.getModel().getSize(); i++) {
                String selectedItem = (String) onlineList.getModel().getElementAt(i);
                String[] info = selectedItem.split(", ");

                try {
                    int destPort = Integer.parseInt(info[1]);
                    if (destPort != Integer.parseInt(localPortField.getText())) {
                        InetAddress destIP = InetAddress.getByName(info[0]);
                        String finalMessage = time + " " + username + ": " + dataMessage;
                        sendingArea.setText("");
                        sendData(destIP, destPort, finalMessage);

                        if (sendToServer) {
                            String command = "/print ";
                            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                            outToServer.writeBytes(command + time + " " + userNameField.getText() + ": " + dataMessage + "\n");
                            sendToServer = false;
                        }
                        statusField.setText("Sent to All Users");
                    }
                } catch (UnknownHostException ex) {
                    ex.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_toAllButtonActionPerformed

    private void sendingAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sendingAreaFocusGained
        if (sendingArea.getText().equals("Enter Text Here")) {
            sendingArea.setText("");
            sendingArea.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_sendingAreaFocusGained

    private void sendingAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sendingAreaFocusLost
        if (sendingArea.getText().trim().isEmpty()) {
            sendingArea.setForeground(Color.GRAY);
            sendingArea.setText("Enter Text Here");
            sendButton.setEnabled(false);
            toAllButton.setEnabled(false);
        }
    }//GEN-LAST:event_sendingAreaFocusLost

    private void onlineListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onlineListMouseClicked
        if (onlineList != null && evt.getClickCount() == 1) {
                selectedUser = (String) onlineList.getSelectedValue();
                
                if (selectedUser != null) {
                    String[] info = selectedUser.split(", ");
                    remoteIpField.setText(info[0]);
                    remotePortField.setText(info[1]);
                }
            }
    }//GEN-LAST:event_onlineListMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logoutButtonActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void onlineListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onlineListValueChanged
        for (int i = 0; i < onlineList.getModel().getSize(); i++) {
            if (selectedUser.equals(onlineList.getModel().getElementAt(i))) {
                return;
            }
        }
        remoteIpField.setText("Select a user from the list");
        remotePortField.setText("Select a user from the list");
    }//GEN-LAST:event_onlineListValueChanged

    private void updateLoggingArea() {
        loggingArea.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (userNames.get(index).equals("Ali:")) {
                    renderer.setForeground(Color.BLUE);
                } else if (userNames.get(index).equals("Saly:")) {
                    renderer.setForeground(Color.RED);
                } else if (userNames.get(index).equals("Aws:")) {
                    renderer.setForeground(new Color(0, 100, 0));
                } else if (userNames.get(index).equals("Adam:")) {
                    renderer.setForeground(Color.MAGENTA);
                }

                return renderer;
            }
        });
    }
    
    private void updateLoginButtonState() {
        if (userNameField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()
            || tcpServerIpField.getText().trim().isEmpty() || tcpServerPortField.getText().trim().isEmpty()
            || localIpField.getText().trim().isEmpty() || localPortField.getText().trim().isEmpty()) {
            loginButton.setEnabled(false);
        } else {
            loginButton.setEnabled(true);
        }
    }
    
    private void updateTestButtonState() {
        if (localIpField.getText().trim().isEmpty() || localPortField.getText().trim().isEmpty()
            || remoteIpField.getText().trim().isEmpty() || remotePortField.getText().trim().isEmpty()
            || remoteIpField.getText().equals("Select a user from the list")
            || remotePortField.getText().equals("Select a user from the list")) {
            testButton.setEnabled(false);
        } else {
            testButton.setEnabled(true);
        }
    }
    
    private void updateSendButtonState() {
        if (sendingArea.getText().trim().isEmpty()) {
            sendButton.setEnabled(false);
            toAllButton.setEnabled(false);
        } else if (running && !sendingArea.getForeground().equals(Color.GRAY)) {
            sendButton.setEnabled(true);
            toAllButton.setEnabled(true);
        }
    }
    
    public void sendData(InetAddress destIP, int destPort, String message) {
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, destIP, destPort);
        try {
            socket.send(sendPacket);
            statusField.setText("Sent to IP = " + destIP.toString().split("/")[1] + ", Port = " + destPort);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception exp) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        com.formdev.flatlaf.FlatIntelliJLaf.setup();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TCPChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel connectPanel;
    private javax.swing.JTextField localIpField;
    private javax.swing.JLabel localIpLabel;
    private javax.swing.JTextField localPortField;
    private javax.swing.JLabel localPortLabel;
    public javax.swing.JList<String> loggingArea;
    private javax.swing.JScrollPane loggingAreaScrollPane;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JList<String> onlineList;
    private javax.swing.JScrollPane onlineListScrollPane;
    private javax.swing.JLabel onlineUsersLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField remoteIpField;
    private javax.swing.JLabel remoteIpLabel;
    private javax.swing.JTextField remotePortField;
    private javax.swing.JLabel remotePortLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextArea sendingArea;
    private javax.swing.JScrollPane sendingAreaScrollPane;
    public javax.swing.JTextField statusField;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField tcpServerIpField;
    private javax.swing.JLabel tcpServerIpLabel;
    private javax.swing.JTextField tcpServerPortField;
    private javax.swing.JLabel tcpServerPortLabel;
    private javax.swing.JButton testButton;
    private javax.swing.JButton toAllButton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
