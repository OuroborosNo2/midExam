package cn.qgstudio.view;

import cn.qgstudio.constant.SystemConstant;
import cn.qgstudio.service.CheckCodeService;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class InputCodeDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private void onOK() throws Exception {


            String code = this.inputCode.getText();
            System.out.println("用户输入的密文是:" + code);
            if (code == null || Objects.equals(code, "")) {
                JOptionPane.showMessageDialog(null,"请输入授权码");
                return;
            }
            boolean b = new CheckCodeService().checkCode(code);
            if (b) {
                Main.checkCode = b;
                dispose();
                return;
            }else {
                int i = JOptionPane.showConfirmDialog(null, "授权失败,是否重新验证?");
                if (i != 0) {
                    Main.checkCode = false;
                    dispose();
                }
            }
            this.inputCode.setText("");
        // 在此处添加代码

    }
    private JButton buttonCancel;

    private JTextField inputCode;

    public InputCodeDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 单击十字时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public void init() {
        InputCodeDialog dialog = new InputCodeDialog();
        dialog.setSize(500,400);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
