import React, { Component } from "react";
import axios from "axios";
import { Table,Button, Input } from "antd";
// import "../css/peoplenews.css";
class PeopleNews extends Component {
  constructor(props) {
    super(props);
    this.state = {
      test: "新闻资讯",
      trans: "",
    //   list:[],
    };
    this.news = this.news.bind(this);
  }
  news() {
    //将插入的值插入到"Input_word"中
    // var id = document.getElementById("Input_city").value;
    // 前端请求，传值word
    axios.get("http://localhost:8080/news/").then(response => {
      // 后端返回
      console.log(response);
      console.log(response.data.data);
    //   console.log(response.data[0]);
    //   console.log(response.data[1]);
      this.setState({
        // trans: response.data.Translation_word.replace(/\|/g, "\n")
        trans:response.data.data,
        // list:[response.data.data[0]]
      });
    });
  }
  render() {
    const columns = [
      {
        title: '标题',
        dataIndex: 'title',
        key: 'title',
      },
    //   {
    //     title: '类别',
    //     dataIndex: 'category',
    //     key: 'category',
    //   },
      {
        title: '时间',
        dataIndex: 'date',
        key: 'date',
      },        
      {
        title: '作者',
        dataIndex: 'author_name',
        key: 'author_name',
      },
      {
        title: '访问链接',
        dataIndex: 'url',
        key: 'url',
      },
    ];

    return (
      <div>
        <h1>{this.state.test}</h1>
        
        <hr />
        <div>
        {/* <Input
          id="Input_city"
          style={{
            margin: "10px",
            width: "300px"
          }}
        /> */}
        <span>最新时尚新闻：</span>
        <Button size="large" onClick={this.news}>
        查询
        </Button>
        <Table style={{paddingBottom:"1cm",height:"100%"}} dataSource={this.state.trans} columns={columns} bordered/>;
      </div>
    </div>
    );
  }
}
export default PeopleNews;
