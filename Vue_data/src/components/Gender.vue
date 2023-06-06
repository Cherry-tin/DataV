<template>
    <div id="gender"></div>
</template>

<script>
// 导入生命周期函数
import { onMounted } from 'vue';
import axios from 'axios';
import * as echarts from 'echarts'

export default {

    name: 'GenDer',
    setup() {
        const gender = () => {
            axios.get('http://localhost:8888/gender/list').then((sex) => {
                console.log(sex.data);
                // 处理数据
                const data = sex.data;
                var GDdata = [];//饼图数据
                var Gder = [];//性别
                var numb = [];//人数

                // 分类数据
                for (let item = 0; item < data.length; item++) {
                    Gder.push(data[item].type);
                    numb.push(data[item].num);
                }
                // 输入饼图数据
                for (var i = 0; i < Gder.length; i++) {
                    GDdata.push({
                        name: Gder[i],
                        value: numb[i]
                    })
                }
                console.log(GDdata);
                var GDCharts = echarts.init(document.getElementById('gender'));
                var GDoption = {
                    tooltip: {
                        trigger: 'item',
                        formatter: '{b}<br/>人数：{c}'
                    },
                    legend: {
                        top: '15%',
                        left: 'center'
                    },
                    color:['#4651d3','#98bbff'],
                    series: [
                        {
                            type: 'pie',
                            radius: '50%',

                            data: GDdata,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }

                        }

                    ]
                };
                GDCharts.setOption(GDoption);
            }).catch((error) => {
                console.log(error);
            })

        }
        // 调用，执行函数
        onMounted(() => {
            gender();
        });
    }

}
</script>

<style>
#gender {
    position: absolute;
    top: -180px;
    left: -48px;
    width: 400px;
    height: 400px;
}
</style>