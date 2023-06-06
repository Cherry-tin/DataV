<template>
    <div id="campus"></div>
</template>

<script>
// 导入生命周期函数
import { onMounted } from 'vue';
import axios from 'axios';
import * as echarts from 'echarts'

export default {

    name: 'CamPus',
    setup() {
        const gender = () => {
            axios.get('http://localhost:8888/campus/list').then((cam) => {
                // console.log(cam.data);
                // 处理数据
                const data = cam.data;
                var CPdata = [];//饼图数据
                var camp = [];//校区
                var numb = [];//人数

                // 分类数据
                for (let item = 0; item < data.length; item++) {
                    camp.push(data[item].name);
                    numb.push(data[item].value);
                }
                // 输入饼图数据
                for (var i = 0; i < camp.length; i++) {
                    CPdata.push({
                        name: camp[i],
                        value: numb[i]
                    })
                }
                var CPCharts = echarts.init(document.getElementById('campus'));
                var CPoption = {
                    tooltip: {
                        trigger: 'item',
                        
                        // formatter: '{b}<br/>人数：{c}'
                    },
                    legend: {
                        top: '5%',
                        left: 'center'
                    },
                    color:['#b1a9fc','#73c9fc'],
                    series: [
                        {
                            name: '校区分布人数',
                            type: 'pie',
                            radius: ['50%', '70%'],
                            avoidLabelOverlap: false,
                            itemStyle: {
                                borderRadius: 10,
                                borderColor: '#fff',
                                borderWidth: 2
                            },
                            label: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                label: {
                                    show: true,
                                    fontSize: 30,
                                    fontWeight: 'bold'
                                }
                            },
                            labelLine: {
                                show: false
                            },
                            data: CPdata
                        }
                    ]
                };
                CPCharts.setOption(CPoption);
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
#campus {
    width: 300px;
    height: 300px;
    position: absolute;
    top: 30px;
    left: 0;
}
</style>