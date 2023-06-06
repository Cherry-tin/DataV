<template>
    <div class="total">
        <div class="header">
            <h1>2022年某高校录取数据</h1>
        </div>
        <div>
            <el-row>
                <el-col :span="5" class="xiaoqu">
                    <h5>新生校区分布情况</h5>
                    <Campus />
                </el-col>
                <el-col :span="12" class="map">
                    <ChinaMap />
                </el-col>
                <el-col :span="6" class="lishi">
                    <h5>历年本科分数线/投档线</h5>
                    <History />

                </el-col>
            </el-row>
            <el-row>
                <el-col :span="5" class="sex">
                    <h5>新生男女比例</h5>
                    <Gender />
                </el-col>
                <el-col :span="12" class="gd">
                    <Yue></Yue>
                    <h4>广东省部分市录取情况</h4>
                </el-col>
                <el-col :span="6" class="wuli">
                    <Physics />
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
import ChinaMap from "@/components/ChinaMap";
import Yue from "@/components/Yue";
import Physics from "@/components/Physics";
import History from "@/components/History";
import Gender from "@/components/Gender";
import Campus from "@/components/Campus";
export default {
    name: 'DataV',
    components: {
        ChinaMap,
        Yue,
        Physics,
        History,
        Gender,
        Campus
    }
}
</script>

<style>
.total {
    width: 1280px;
    height: 719px;
    margin: 0px auto;
    background-image: url('images/bg.jpg');
    padding-top: 25px;
}

/* 头部标题 */
.header {
    width: 1280px;
    height: 58px;
    background-image: url('images/header.png');
    text-align: center;
    color: #5470c6;
    line-height: 10px;
}

/*  */
.xiaoqu {
    position: relative;
    top: 0;
    left: 0;
    height: 300px;
}

.xiaoqu h5 {
    position: absolute;
    top: -20px;
    left: 96px;
    height: 30px;
    color: #4c4e53;


}

/* 男女比例 */
.sex {
    position: relative;
    top: 0;
    left: 0;
    height: 300px;
}

.sex h5 {
    position: absolute;
    top: -185px;
    left: 110px;
    height: 30px;
    color: #4c4e53;

}

/* 地图部分  */
.map {
    position: relative;
    width: 620px;
    height: 500px;
    /* padding-left: 65px; */
    /* background-color: seashell; */

}

/* 广东省 */
.gd {
    position: relative;
    width: 620px;
    height: 140px;
    /* background-color: pink; */
    padding-bottom: 50px;
    color: #4c4e53;
}

.gd h4 {
    position: absolute;
    left: 294px;
    bottom: -18px;
}

/* 历史部分 */
.lishi {
    position: relative;
    height: 250px;
}

.lishi h5 {
    position: absolute;
    left: 120px;
    top: -20px;
    color: #4c4e53;

}

/* 物理部分 */
.wuli {
    position: relative;
    height: 250px;
}
</style>