import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.jar.JarEntry;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MyFrame extends JFrame {
    MyFrame()
        {
            int workhour = 24;
            int []person2hour ={9,15,16,17,18,19,20,21,22,23};


            setTitle("첫번째 프레임");
            setSize(1000,1200);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            Container container = getContentPane();
            JPanel panel1 = new JPanel();
            container.add(panel1);
            container.setLayout(new GridLayout(0,1));

            String memberList[]={"1","2","3","4","5","8","9","10","11"};
            DefaultListModel<String> members = new DefaultListModel<>();
            for (String member : memberList) members.addElement(member);

            JLabel title1 = new JLabel("격대 인원");
            panel1.add(title1);
            // JList
            JList memberlist = new JList(members);
            memberlist.setFixedCellWidth(40);
            memberlist.setCellRenderer(new DefaultListCellRenderer(){
                public int getHorizontalAlignment() {
                    return CENTER;
                }
            });
            panel1.add(memberlist);

            //입력창
            JTextField addMemberField = new JTextField(10);
            panel1.add(addMemberField);
            JButton addButton = new JButton("대원 추가");

            panel1.add(addButton);
            panel1.setLayout(new FlowLayout());

            JLabel title2 = new JLabel("근무일지");
            JLabel title3 = new JLabel("제외 인원");
            //panel2
            JPanel panel2 = new JPanel();
            container.add(panel2);

            JLabel title4 = new JLabel("외출/격리복귀");
            panel2.add(title2);
            panel2.add(title3);

            panel2.setLayout(new GridLayout(0,1));
            // checkbox
            JPanel radiopanel1 = new JPanel();
            radiopanel1.setLayout(new FlowLayout());
            ArrayList<JCheckBox> excludeCheckBox = new ArrayList<>();
            //JCheckBox []excludeCheckBox;
            //excludeCheckBox = new JCheckBox[members.size()];
            for(int i=0;i<members.size();i++)
            {
                excludeCheckBox.add(new JCheckBox(members.getElementAt(i)));
                //excludeCheckBox[i] = new JCheckBox(members.getElementAt(i));
                radiopanel1.add(excludeCheckBox.get(i));
            }

            panel2.add(radiopanel1);
            panel2.add(title4);
            ArrayList<JCheckBox> returnCheckBox = new ArrayList<>();
            JPanel radiopanel2 = new JPanel();
            //JCheckBox []returnCheckBox;
            //returnCheckBox = new JCheckBox[members.size()];
            for(int i=0;i<members.size();i++)
            {
                returnCheckBox.add(new JCheckBox(members.getElementAt(i)));
                //returnCheckBox[i] = new JCheckBox(members.getElementAt(i));
                radiopanel2.add(returnCheckBox.get(i));
            }
            panel2.add(radiopanel2);


            addButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String name=addMemberField.getText();
                    // JList에 추가하기 작성
                    members.addElement(name);
                    memberlist.setModel(members);
                    excludeCheckBox.add(new JCheckBox(name));
                    returnCheckBox.add(new JCheckBox(name));
                    radiopanel1.add(excludeCheckBox.get(excludeCheckBox.size()-1));
                    radiopanel2.add(returnCheckBox.get(returnCheckBox.size()-1));
                    addMemberField.setText("");//추가후에, 텍스트필드에 남아있는 값 지워주기.
                }
            });
            // panel3 : 근무일지 표

            JPanel panel3 = new JPanel();
            panel3.setLayout(new GridLayout(0,1));
            JLabel p3_t1 = new JLabel("근무 시간 입력");
            panel3.add(p3_t1);
            JPanel workpanel1 = new JPanel();
            workpanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            JTextField []work1;
            work1 = new JTextField[workhour];
            for(int i=0;i<workhour;i++)
            {
                work1[i] = new JTextField(Integer.toString(i),2);
                workpanel1.add(work1[i]);
            }
            panel3.add(workpanel1);

            JPanel workpanel2 = new JPanel();
            workpanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
            JTextField []work2;
            work2 = new JTextField[workhour];
            for(int i=0;i<workhour;i++)
            {
                work2[i] = new JTextField(Integer.toString(i),2);
                boolean exist = false;
                for(int ele : person2hour){
                    if(i == ele){
                        exist = true;
                        break;
                    }
                }
                if(!exist) work2[i].setText("X");
                workpanel2.add(work2[i]);
            }
            panel3.add(workpanel2);


            container.add(panel3);
            setVisible(true);


        }


    public static void main(String[] args)
    {
        new MyFrame();
    }
}
