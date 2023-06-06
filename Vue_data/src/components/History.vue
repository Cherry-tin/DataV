<template>
    <div id="history"></div>
</template>

<script>
// 导入生命周期函数
import { onMounted } from 'vue';
import axios from 'axios';
import * as echarts from 'echarts'

export default {

    name: 'HisTory',
    setup() {
        const gender = () => {
            axios.get('http://localhost:8888/history/list').then((his) => {
                // 处理数据
                var Provdata = [];//省分数线
                var Xhdata = [];//校分数线
                var arrayx = [];//年
                const data = his.data;
                // 分类数据
                for (let item = 0; item < data.length; item++) {
                    arrayx.push(data[item].year);
                    Provdata.push(data[item].province);
                    Xhdata.push(data[item].school);
                }

                var PyhCharts = echarts.init(document.getElementById('history'));
                var Pyhoption = {
                    title: {
                        text: '历史',
                    },
                    tooltip: {
                        trigger: 'axis',

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
                        min: 420,
                        splitNumber: 5,
                    },
                    series: [
                        {
                            name: '该校最低投档线',
                            type: 'line',
                            data: Xhdata,
                            itemStyle: {
                                normal: {
                                    color: '#5e558f'//折线颜色
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
                                    color: '#408cbe',//折线颜色
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
#history {
    position: absolute;
    left: 0;
    top: 50px;
    width: 380px;
    height: 200px;
}
</style>