package Java.EmploySystem.src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeFrame extends JFrame {
    private String LoginUserName = "";
    private JTable table;
    private DefaultTableModel model;

    public EmployeeFrame(String LoginUserName) {
        this.LoginUserName = LoginUserName;
        this.initFrame();
        this.initTable();
        this.initPopupMenu();
    }

    private void initFrame() {
        this.setTitle("员工信息管理(已登录用户-" + LoginUserName + ")");
        this.setSize(700, 420);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
    
    private void initTable() {
        String[] columnNames = {
                "员工编号", "姓名", "性别", "部门", "职位", "联系电话"
        };

        Object[][] data = {
            //生成10个员工信息
            {"1001", "张三", "男", "开发部", "Java工程师", "13810000001"},
            {"1003", "王五", "男", "财务部", "财务经理", "13810000003"},
            {"1004", "赵六", "女", "市场部", "市场总监", "13810000004"},
            {"1005", "李四", "男", "人事部", "人事经理", "13810000005"},
            {"1006", "周七", "女", "销售部", "销售员", "13810000006"},  
            {"1008", "吴九", "女", "产品部", "产品经理", "13810000008"},
            {"1009", "郑十", "男", "人事部", "人事经理", "13810000009"},
            {"1010", "陈一", "男", "行政部", "行政经理", "13810000010"},
            {"1011", "褚二", "男", "运营部", "运营总监", "13810000011"},
            {"1012", "卫三", "女", "技术部", "技术总监", "13810000012"},
            {"1013", "蒋四", "男", "质量部", "质量经理", "13810000013"}

        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        table.setRowHeight(28);
        table.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));

        this.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // ================= 右键菜单 =================
    private void initPopupMenu() {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem addItem = new JMenuItem("新增员工");
        JMenuItem editItem = new JMenuItem("修改单元格");
        JMenuItem deleteItem = new JMenuItem("删除当前行");
        JMenuItem viewItem = new JMenuItem("查看员工信息");

        popupMenu.add(addItem);
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        popupMenu.addSeparator();
        popupMenu.add(viewItem);

        // 右键监听
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showMenu(e);
            }

            private void showMenu(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row != -1) {
                        table.setRowSelectionInterval(row, row);
                    }
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });

        // ================= CRUD 事件 =================

        // 新增
        addItem.addActionListener(e -> addEmployee());

        // 修改单元格
        editItem.addActionListener(e -> editCell());

        // 删除
        deleteItem.addActionListener(e -> deleteRow());

        // 查看
        viewItem.addActionListener(e -> viewRow());
    }

    // ================= CRUD 方法 =================

    private void addEmployee() {
        JTextField[] fields = new JTextField[6];
        String[] labels = {"员工编号", "姓名", "性别", "部门", "职位", "联系电话"};

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        for (int i = 0; i < 6; i++) {
            panel.add(new JLabel(labels[i]));
            fields[i] = new JTextField();
            panel.add(fields[i]);
        }

        int result = JOptionPane.showConfirmDialog(
                this, panel, "新增员工", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            Object[] rowData = new Object[6];
            for (int i = 0; i < 6; i++) {
                rowData[i] = fields[i].getText();
            }
            model.addRow(rowData);
        }
    }

    private void editCell() {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();

        if (row == -1 || col == -1) {
            JOptionPane.showMessageDialog(this, "请选择要修改的单元格");
            return;
        }

        String oldValue = model.getValueAt(row, col).toString();
        String newValue = JOptionPane.showInputDialog(
                this, "请输入新值：", oldValue);

        if (newValue != null) {
            model.setValueAt(newValue, row, col);
        }
    }

    private void deleteRow() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "请选择要删除的行");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this, "确定删除该员工？", "确认", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            model.removeRow(row);
        }
    }

    private void viewRow() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < model.getColumnCount(); i++) {
            sb.append(model.getColumnName(i))
              .append("：")
              .append(model.getValueAt(row, i))
              .append("\n");
        }

        JOptionPane.showMessageDialog(
                this, sb.toString(), "员工信息", JOptionPane.INFORMATION_MESSAGE);
    }
}
