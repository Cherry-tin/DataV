<template>
  <div id="cn_map"></div>
</template>

<script>

import axios from 'axios';
import * as echarts from 'echarts'
// 导入生命周期函数
import { onMounted } from 'vue';
export default {
  name: 'ChinaMap',
  setup() {
    const cnMap = () => {
      // 录取人数数据
      var Cdata = [];
      //地图数据
      var mapdata;
      axios.get('http://localhost:8888/chinamap/list').then((snum) => {
        // 处理录取数据
        const data = snum.data
        var area = [];//地区
        var sumb = [];//人数
        // 用循环遍历数据
        for (var item = 0; item < data.length; item++) {
          area.push(data[item].name);
          sumb.push(data[item].value);
        }
        // 加入录取人数数据
        for (var i = 0; i < area.length; i++) {
          Cdata.push({
            value: sumb[i],
            name: area[i]
          })
        }
        // then请求成功，catch请求失败
        axios.get('http://localhost:8080/china.json').then((res) => {
          console.log(res.data);
          // 储存地图数据
          mapdata = res.data;
          var chinaCharts = echarts.init(document.getElementById('cn_map'));
          // 在axios的回调函数中注册地图矢量数据
          echarts.registerMap('chinaMap', mapdata);
          var CNoption = {
            // 鼠标悬停显示数据
            tooltip: {
              trigger: 'item',
              formatter: '{b}<br/>录取人数：{c}'
            },
            // 热力图
            visualMap: {
              show: true,
              min: 0,
              max: 200,
              text: ['High', 'Low'],
              realtime: false,
              calculable: true,
              inRange: {
                color: ['#b6c7e5', '#4f7bde']
              },
              bottom: '5%'

            },

            series: [{
              type: 'map',
              map: 'chinaMap',
              data: Cdata,
              // roam: true,  //允许缩放以及拖动效果
              // label: {
              //   show: true  //显示标签
              // },

              zoom: 1.5,    //初始的大小比例
              center: [106.278179, 38.46637],// 设置地图中心点的坐标
              // 鼠标悬停效果
              emphasis: {
                label: {
                  textStyle: { color: '#fff' },//悬停时字体颜色
                },
                itemStyle: {
                  areaColor: '#3c4bc6' //区域颜色
                }
              },
              itemStyle: {
                // 设置边框为白色
                normal: {
                  borderWidth: 0.5,//边界线大小
                  borderColor: '#fff',//边界线颜色
                }
              }
            }]

          };
          chinaCharts.setOption(CNoption);
        }).catch((error) => {
          console.log(error);
        });

      }).catch((error) => {
        console.log(error);
      });

    }
    // 调用，执行函数
    onMounted(() => {
      cnMap();
    });

  }
}
</script>

<style>
#cn_map {
  position: absolute;
  left: 65px;
  top: -35px;
  width: 620px;
  height: 500px;
/* 
  background-color: pink; */
}
</style>