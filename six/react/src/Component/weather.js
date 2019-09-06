import React, { Component } from "react";
import axios from "axios";
import { Button, Input } from "antd";

class Translate extends Component {
  constructor(props) {
    super(props);
    this.state = {
      test: "天气预报",
      trans: ""
    };
    this.translations = this.translations.bind(this);
  }
  translations() {
    //将插入的值插入到"Input_word"中
    var city = document.getElementById("Input_city").value;
    // 前端请求，传值word
    axios.get("http://localhost:8080/weathercity/" + city).then(response => {
      // 后端返回
      console.log(response);
      console.log(response.data);
      console.log(response.data[0]);
      console.log(response.data[1]);
      this.setState({
        // trans: response.data.Translation_word.replace(/\|/g, "\n")
        trans:response.data
      });
    });
  }
  render() {
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

        <Input.TextArea
          value={this.state.trans}
          style={{
            height: "200px"
          }}
        />
      </div>
    </div>
    );
  }
}
export default Translate;