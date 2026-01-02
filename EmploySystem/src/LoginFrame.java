package EmploySystem.src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginFrame extends JFrame{

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private static final LoginFrame INSTANCE = new LoginFrame();

    private static ArrayList<User> users = new ArrayList<>();
    static{
        users.add(new User("admin", "管理员", "123456"));
        users.add(new User("user1", "普通用户1", "123456"));
        users.add(new User("user2", "普通用户2", "123456"));
        users.add(new User("user3", "普通用户3", "123456"));
    }
    private LoginFrame() {
        this.initFrame();
        this.initComponents();
        this.bindEvents();
        this.getRootPane().setDefaultButton(loginButton);
    }
    
    private void initFrame() {
        this.setTitle("员工管理系统 - 登录");
        this.setSize(400, 260);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 标题
        JLabel titleLabel = new JLabel("员工管理系统", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // 表单区
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("用户名："), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        formPanel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("密码："), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        formPanel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginButton = new JButton("登录");
        loginButton.setPreferredSize(new Dimension(100, 30));
        formPanel.add(loginButton, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel);
    }

    private void bindEvents() {
        loginButton.addActionListener(e->doLogin());
    }

    private void doLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean usernameStatus = username.isEmpty();
        boolean passwordStatus = password.isEmpty();
        boolean DataVerifyResult = false;
        // 示例校验（你后面可以换成数据库）
            //两者都不为空
            if(!usernameStatus && !passwordStatus){
                for (User user : users){
                    if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
                        DataVerifyResult = true;
                        break;
                    }
                }
                if(DataVerifyResult){
                    EmployeeFrame eFrame = new EmployeeFrame(username);
                    eFrame.setVisible(true);
                    this.dispose();
                    return;
                }else{
                    JOptionPane.showConfirmDialog(this, "账号或密码错误，请重试！");
                    return;
                }
                //至少一个为空
            }else{
                if(usernameStatus && !(passwordStatus)){
                    JOptionPane.showConfirmDialog(this, "请输入用户名！");
                    return;
                }else if(passwordStatus && !(usernameStatus)){
                    JOptionPane.showConfirmDialog(this, "请输入密码！");
                    return;
                }else{
                    JOptionPane.showConfirmDialog(this, "请输入用户名和密码！");
                    return;
                }
            }
        
        
    }

    public static LoginFrame getInstance() {
        return INSTANCE;
    }
    
    
}
