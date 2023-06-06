<template>
    <div id="yue"></div>
</template>

<script>
// 导入生命周期函数
import { onMounted } from 'vue';
import axios from 'axios';
import * as echarts from 'echarts'

export default {

    name: 'GuangDong',
    setup() {
        const gender = () => {
            axios.get('http://localhost:8888/guangdong/list').then((gdong) => {
                // console.log(cam.data);
                // 处理数据
                const data = gdong.data;

                var arrayx = [];//市名
                var arrayy = [];//人数

                // 分类数据
                for (let item = 0; item < data.length; item++) {
                    arrayx.push(data[item].name);
                    arrayy.push(data[item].value);
                }

                var YueCharts = echarts.init(document.getElementById('yue'));
                var Yueoption = {
                    // title: {
                    //     text: '2022年广东省录取人数最多城市top9',
                    //     left: 'center',
                    //     bottom:'0%'
                    // },
                    // 鼠标悬停样式
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    grid: {
                        left: '0%',
                        right: '0%',
                        bottom: '0%',
                        top:'5%',
                        containLabel: true
                    },
                    xAxis: [
                        {
                            type: 'category',
                            data: arrayx,
                            axisTick: {
                                alignWithLabel: true
                            }
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '录取人数',
                            type: 'bar',
                            barWidth: '50%',
                            data: arrayy
                        }
                    ]
                };
                YueCharts.setOption(Yueoption);
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
#yue {
    position: absolute;
    left: 55px;
    top: -35px;
    width: 620px;
    height: 142px;
    /* background-color: #ccc; */
}
</style>