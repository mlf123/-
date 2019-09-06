import React, { Component } from "react";
import { Layout, Menu, Icon, Input, Button } from "antd";
import Translate from "../Component/translate";
import PeopleNews from "../Component/peoplenews";
import News from "../Component/news";
import Weather from "../Component/weather";
import { HashRouter, Switch, Route, Link } from "react-router-dom";
// import "../../css/main.less";src外面
import "../css/main.less";
const { Header, Sider, Content, Footer } = Layout;
const MenuItem = Menu.Item;

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      collapsed: false
    };
    this.toggle = this.toggle.bind(this);
  }
  toggle() {
    this.setState({
      collapsed: !this.state.collapsed
    });
  }
  render() {
    return (
      <HashRouter>
        <Layout className="c1-layout" style={{height: '100%'}}>
          <Sider trigger={null} collapsible collapsed={this.state.collapsed}>
            <div className="logo">应用</div>
            <Menu theme="dark" mode="inline" defaultSelectedKeys={["1"]}>
              <MenuItem key="1">
                <Icon type="sync" />
                <span>中英翻译</span>
                <Link to="/Translate" />
              </MenuItem>
              <MenuItem key="2">
                <Icon type="search" />
                <span>员工信息查询</span>
                <Link to="/peopleNews" />
              </MenuItem> 
              <MenuItem key="3">
                <Icon type="book" />
                <span>新闻查询</span>
                <Link to="/news" />
              </MenuItem>
              <MenuItem key="4">
                <Icon type="cloud" />
                <span>天气查询</span>
                <Link to="/weather" />
              </MenuItem>
              
            </Menu>
          </Sider>
          <Layout>
            <Header style={{ background: "#fff", padding: 0 }}>
              <Icon
                className="trigger"
                type={this.state.collapsed ? "menu-unfold" : "menu-fold"}
                onClick={this.toggle}
              />
            </Header>
            <Content style={{margin: "24px 16px",padding: 24,background: "#fff" }}>
              <Switch>
                <Route path="/Translate" component={Translate} />
                <Route path="/peopleNews" component={PeopleNews} />
                <Route path="/news" component={News} />
                <Route path="/weather" component={Weather} />
              </Switch>
            </Content>
          </Layout>
        </Layout>
      </HashRouter>
    );
  }
}
export default App;
