import React, { Component } from "react";
import axios from "axios";
import { Table,Button, Input } from "antd";
// import "../css/peoplenews.css";
class PeopleNews extends Component {
  constructor(props) {
    super(props);
    this.state = {
      test: "员工信息查询",
      trans: "",
      list:[],
    };
    this.translations = this.translations.bind(this);
  }
  translations() {
    //将插入的值插入到"Input_word"中
    var id = document.getElementById("Input_city").value;
    // 前端请求，传值word
    axios.get("http://localhost:8080/peoplenews/" + id).then(response => {
      // 后端返回
      console.log(response);
      console.log(response.data);
      // console.log(response.data[0]);
      // console.log(response.data[1]);
      this.setState({
        // trans: response.data.Translation_word.replace(/\|/g, "\n")
        // trans:response.data
        list:[response.data]
      });
    });
  }
  render() {
    // const dataSource = [
    //   {
    //     key: '1',
    //     usercode: '{this.state.trans.usercode}',
    //     username: 32,
    //     department: '西湖区湖底公园1号',
    //     hiredate: '西湖区湖底公园1号',
    //   }
    // ];
    const columns = [
      {
        title: '工号',
        dataIndex: 'usercode',
        key: 'usercode',
      },
      {
        title: '姓名',
        dataIndex: 'username',
        key: 'username',
      },
      {
        title: '部门',
        dataIndex: 'department',
        key: 'department',
      },
      {
        title: '入职日期',
        dataIndex: 'hiredate',
        key: 'hiredate',
      },
    ];

    return (
      <div>
        <h1>{this.state.test}</h1>
        <hr />
        <div>
        <Input
          id="Input_city"
          style={{
            margin: "10px",
            width: "300px"
          }}
        />
        <Button size="large" onClick={this.translations}>
        查询
        </Button>
        {/* <table name="table1">
          <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>部门</td>
            <td>入职日期</td>
          </tr>
          <tr>
            <td>{this.state.trans.usercode}</td>
            <td>{this.state.trans.username}</td>
            <td>{this.state.trans.department}</td>
            <td>{this.state.trans.hiredate}</td>
          </tr>
        </table>  */}
        <Table dataSource={this.state.list} columns={columns} bordered/>;
      </div>
    </div>
    );
  }
}
export default PeopleNews;
