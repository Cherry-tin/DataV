<template>
    <div id="physics"></div>
</template>

<script>
// 导入生命周期函数
import { onMounted } from 'vue';
import axios from 'axios';
import * as echarts from 'echarts'

export default {

    name: 'PhySics',
    setup() {
        const gender = () => {
            axios.get('http://localhost:8888/physics/list').then((phy) => {
                // 处理数据
                var Provdata = [];//省分数线
                var Xhdata = [];//校分数线
                var arrayx = [];//年
                const data = phy.data;
                // 分类数据
                for (let item = 0; item < data.length; item++) {
                    arrayx.push(data[item].year);
                    Provdata.push(data[item].province);
                    Xhdata.push(data[item].school);
                }

                var PyhCharts = echarts.init(document.getElementById('physics'));
                var Pyhoption = {
                    title: {
                        text: '物理'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['该校最低投档线', '广东省本科批']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'category',
                        // boundaryGap: false,
                        data: arrayx
                    },
                    yAxis: {
                        type: 'value',
                        max: 500,
                        min: 360,
                        splitNumber: 5,
                    },
                    series: [
                    {
                            name: '该校最低投档线',
                            type: 'line',
                            data: Xhdata,
                            itemStyle: {
                                normal: {
                                    color: '#73c9fc',//折线颜色
                                }
                            },
                            markPoint: {//设置最大最小标签
                                data: [
                                    { type: 'max', name: 'Max' },
                                    { type: 'min', name: 'Min' }
                                ]
                            },
                        },
                        {
                            name: '广东省本科批',
                            type: 'line',
                            itemStyle: {
                                normal: {
                                    color: '#b1a9fc',//折线颜色
                                }
                            },
                            markPoint: {
                                data: [
                                    { type: 'max', name: 'Max' },
                                    { type: 'min', name: 'Min' }
                                ]
                            },
                            data: Provdata
                        }
                    ]

                };
                PyhCharts.setOption(Pyhoption);

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
#physics {
    position: absolute;
    left: 0;
    bottom: 230px;
    width: 380px;
    height: 200px;
}
</style>