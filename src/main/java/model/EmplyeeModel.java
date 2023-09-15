package model;

import dto.EmployDTO;
import util.webCam.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmplyeeModel {
    public boolean save(EmployDTO employDTO) {
        boolean execute = false;
        try {
            String sql = "insert into employee (employee_id, employee_name, address, tele, gmail)  VALUES (?,?,?,?,?)";
            execute = CrudUtil.execute(sql, employDTO.getEmployee_id(), employDTO.getName(), employDTO.getAddress(), employDTO.getTele(), employDTO.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return execute;
    }
    public List<EmployDTO> getAll() {
        List<EmployDTO> employDTOList = new ArrayList<>();
        String sql = "select * from employee";
        try {
            ResultSet execute = CrudUtil.execute(sql);
            while (execute.next()) {
                String id = execute.getString(1);
                String name = execute.getString(2);
                String addrerss = execute.getString(3);
                String tele = execute.getString(4);
                String gmail = execute.getString(5);
                employDTOList.add(new EmployDTO(id,tele,name,addrerss,gmail));
            }
            return employDTOList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
