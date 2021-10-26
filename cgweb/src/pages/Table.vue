<template>
  <div class="h-full">
    <div class="flex flex-col px-2 mt-2">
      <div class="p-1  flex">
          <div class="p-1">
              <select v-model="datasource">
                <option v-for="(d, i) in datasourceType" :key="d" :value="i">
                  {{ d.name }}
                </option>
              </select>
          </div>
          <div v-if="datasource==1">
             <input
              placeholder="数据来源sql"
              v-model="datasourceMeta.sql"
              class="px-2 mx-2 border hover:border-gray-400 rounded"
            />
          </div>

          <div v-if="datasource==1">
             <input
              placeholder="名称空间"
              v-model="packageName"
              class="px-2 mx-2 border hover:border-gray-400 rounded"
            />
          </div>

          <input
            placeholder="请求前缀"
            v-model="urlprefix"
            class="px-2 mx-2 border hover:border-gray-400 rounded"
          />
      </div>
      <div class="px-1 flex">
       
        <input
          placeholder="模块名称"
          v-model="moduleDisplayName"
          class="px-2 mx-2 border hover:border-gray-400 rounded"
        />
        <input
          placeholder="模块名称"
          v-model="moduleName"
          class="px-2 mx-2 border hover:border-gray-400 rounded"
        />
      
      </div>

      <div class="px-1 flex">
        <label
          v-for="(d, i) in targetList"
          :key="d"
          :value="i"
          class="flex items-center"
        >
          <input
            type="checkbox"
            v-model="d.select"
            class="px-2 mx-2 border hover:border-gray-400 rounded"
          />
          <div>{{ d.name }}</div>
        </label>
      </div>
      <div class="px-1 flex">
        <CheckIcon class="h-4 pl-2" @click="generateCode()"></CheckIcon>
      </div>
    </div>
    <div class="flex flex-col px-2">
      <div v-for="(g, gi) in table.group" :key="g">
        <div class="py-2 flex items-center">
          <div>
            <div class="flex pl-2 text-gray-600">
              <PlusIcon class="w-4" @click="addGroup(gi, g)"></PlusIcon>
              <MinusIcon class="w-4" @click="removeGroup(gi, g)"></MinusIcon>
              <FolderIcon
                class="w-4"
                v-if="g.unfold"
                @click="unfoldGroup(gi, g)"
              ></FolderIcon>
              <FolderOpenIcon
                class="w-4"
                v-if="!g.unfold"
                @click="unfoldGroup(gi, g)"
              ></FolderOpenIcon>
            </div>
          </div>
          <div class="pl-2 flex items-center">
            <input
              v-model="g.name"
              class="px-2 mx-2 border hover:border-gray-400 rounded"
            />
            <input
              v-model="g.displayName"
              class="px-2 mx-2 border hover:border-gray-400 rounded"
            />
            <input
              v-model="g.comment"
              class="px-2 mx-2 border hover:border-gray-400 rounded"
            />

            <div class="px-2">
              <select v-model="g.relationType">
                <option v-for="(d, i) in relationType" :key="d" :value="i">
                  {{ d.name }}
                </option>
              </select>
            </div>
            <div class="px-2">
              <input v-model="g.listDisplay" type="checkbox" />列表显示
            </div>
            <div class="px-2">
              <input v-model="g.display" type="checkbox" value="3" />表单显示
            </div>
            <div class="px-2">
              <input
                v-model="g.cacheLastOne"
                type="checkbox"
                value="3"
              />最后一条
            </div>
            <input
              placeholder="宽度"
              v-model="g.width"
              class="mx-2 px-2 border hover:border-gray-400 rounded"
            />
            <div class="px-2">
              <input v-model="g.combine" type="checkbox" value="3" />合并
            </div>
            <div class="px-2">
              <input v-model="g.role" type="checkbox" value="admin" />管理员
            </div>
          </div>
        </div>
        <div class="pl-4 flex" v-if="g.unfold">
          <div class="flex py-2 text-gray-600 items-center">
            <input
              class="pl-4"
              v-model="g.select"
              type="checkbox"
              @input="selectAllGroup(g)"
            />
            <PlusIcon class="h-4 pl-2" @click="addColumn(0, c, g)"></PlusIcon>
            <CheckIcon class="h-4 pl-2" @click="checkGroup(gi, g)"></CheckIcon>
            <DuplicateIcon
              class="h-4 pl-2"
              @click="newGroup(gi, g)"
            ></DuplicateIcon>
          </div>
        </div>
        <div v-if="g.unfold">
          <div
            v-for="(c, i) in g.columns"
            :key="c"
            class="px-2 pl-4 py-2 flex border border-gray-200"
          >
            <div class="flex text-gray-600">
              <div class="flex items-center px-1">
                <input v-model="c.select" type="checkbox" />
              </div>
              <PlusIcon class="w-4" @click="addColumn(i, c, g)"></PlusIcon>
              <MinusIcon class="w-4" @click="removeColumn(i, c, g)"></MinusIcon>
              <ArrowUpIcon class="w-4" @click="upColumn(i, c, g)"></ArrowUpIcon>
              <ArrowDownIcon
                class="w-4"
                @click="downColumn(i, c, g)"
              ></ArrowDownIcon>

              <!-- <DuplicateIcon class="w-4" @click="copyColumn(i)"></DuplicateIcon> -->
            </div>
            <input
              v-model="c.name"
              class="mx-2 px-2 border hover:border-gray-400 rounded"
            />
            <input
              v-model="c.comment"
              class="mx-2 px-2 border hover:border-gray-400 rounded"
            />
            <input
              placeholder="宽度"
              v-model="c.width"
              class="mx-2 px-2 border hover:border-gray-400 rounded"
            />
            <div class="px-2">
              <input v-model="c.listDisplay" type="checkbox" />列表
            </div>
            <div class="">
              <select v-model="c.listRenderType">
                <option v-for="(d, i) in renderType" :key="d" :value="i">
                  {{ d.name }}
                </option>
              </select>
            </div>

            <div class="flex items-center px-1">
              <input v-model="c.sortDisplay" type="checkbox" />
              <div>排序</div>
            </div>
            <div class="flex items-center px-1">
              <input v-model="c.searchDisplay" type="checkbox" />
              <div>搜索</div>
            </div>

            <div class="">
              <input v-model="c.detailDisplay" type="checkbox" />详情
            </div>
             <div class="">
              <input v-model="c.batchOps" type="checkbox" />批量操作
            </div>
            <div class="px-1">
              <select v-model="c.detailRenderType">
                <option v-for="(d, i) in renderType" :key="d" :value="i">
                  {{ d.name }}
                </option>
              </select>
            </div>
            <div class="flex items-center px-1">
              <input v-model="c.required" type="checkbox" />
              <div>必填</div>
            </div>

            <div class="flex items-center px-1">
              <input v-model="c.automaticGenerated" type="checkbox" />
              <div>自动生成</div>
            </div>

            <div class="flex items-center px-1">
              <input v-model="c.primaryKey" type="checkbox" />
              <div>主键</div>
            </div>

            <div class="flex items-center px-1">
              <input v-model="c.databaseDisplay" type="checkbox" />
              <div>虚拟列</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <table>
      <thead>
        <tr>
          <template v-for="g in table.group" :key="g">
            <template
              v-if="g.relationType == 0 && g.listDisplay"
              :style="{
                width: g.width,
              }"
            >
              <template v-if="g.combine">
                <th
                  class=""
                  :style="{
                    width: g.width,
                  }"
                >
                  {{ g.displayName }}
                </th>
              </template>
              <template v-if="!g.combine">
                <template v-for="l in g.columns" :key="l">
                  <th
                    class=""
                    v-if="l.listDisplay"
                    :style="{
                      width: l.width,
                    }"
                  >
                    <div>{{ l.listName }}</div>
                    <div class="flex" v-if="l.sortDisplay">
                      <ArrowUpIcon class="w-2"></ArrowUpIcon>
                      <ArrowDownIcon class="w-2"></ArrowDownIcon>
                    </div>
                  </th>
                </template>
              </template>
            </template>
          </template>
        </tr>
      </thead>
      <tbody>
        <tr>
          <template v-for="g in table.group" :key="g" class="flex">
            <template
              v-if="g.relationType == 0 && g.listDisplay"
              :style="{
                width: g.width,
              }"
            >
              <template v-if="g.combine">
                <td class="">
                  <div class="flex">
                    <template v-for="l in g.columns" :key="l">
                      <div>
                        <div
                          v-if="l.listDisplay"
                          :style="{
                            width: l.width,
                          }"
                        >
                          <component
                            v-bind:is="
                              renderType[l.listRenderType].render || 'Text'
                            "
                          ></component>
                        </div>
                      </div>
                    </template>
                  </div>
                </td>
              </template>
              <template v-if="!g.combine">
                <template v-for="l in g.columns" :key="l">
                  <td
                    class=""
                    v-if="l.listDisplay"
                    :style="{
                      width: l.width,
                    }"
                  >
                    <component
                      v-bind:is="renderType[l.listRenderType].render || 'Text'"
                    ></component>
                  </td>
                </template>
              </template>
            </template>
          </template>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import {
  LockClosedIcon,
  PlusIcon,
  MinusIcon,
  ArrowUpIcon,
  ArrowDownIcon,
  DuplicateIcon,
  FolderIcon,
  FolderOpenIcon,
  CheckIcon,
} from "@heroicons/vue/solid";

import {
  Text,
  Avatar,
  Button,
  Customize,
  Date,
  Image,
  Link,
  None,
  Number,
  Switch,
} from "./render/index.js";


import data from "../data.js"

export default {
  name: "Table",
  components: {
    LockClosedIcon,
    PlusIcon,
    MinusIcon,
    ArrowUpIcon,
    ArrowDownIcon,
    DuplicateIcon,
    FolderIcon,
    FolderOpenIcon,
    CheckIcon,
    Text,
    Avatar,
    Button,
    Customize,
    Date,
    Image,
    Link,
    None,
    Number,
    Switch,
  },
  methods: {
    generateCode() {
      console.log("正在生成请稍等");
    },
    downColumn(i, c, g) {
      g.columns = [
        ...g.columns.slice(0, i),
        g.columns[i + 1],
        c,
        ...g.columns.slice(i + 2, g.columns.length),
      ];
    },
    upColumn(i, c, g) {
      g.columns = [
        ...g.columns.slice(0, i - 1),
        c,
        g.columns[i - 1],
        ...g.columns.slice(i + 1, g.columns.length),
      ];
    },
    removeColumn(i, c, g) {
      g.columns = [
        ...g.columns.slice(0, i),
        ...g.columns.slice(i + 1, g.columns.length),
      ];
    },
    addColumn(i, c, g) {
      g.columns = [
        ...g.columns.slice(0, i + 1),
        {
          name: "",
        },
        ...g.columns.slice(i + 1, g.columns.length),
      ];
    },
    removeGroup(i, g) {
      this.table.group = [
        ...this.table.group.slice(0, i),
        ...this.table.group.slice(i + 1, this.table.group.length),
      ];
    },
    addGroup(i, g) {
      this.table.group = [
        ...this.table.group.slice(0, i + 1),
        {
          name: "",
          relationType: 0,
          columns: [],
        },
        ...this.table.group.slice(i + 1, this.table.group.length),
      ];
    },
    unfoldGroup(i, g) {
      g.unfold = !g.unfold;
    },
    selectAllGroup(g) {
      g.columns.forEach((c) => {
        c.select = !g.select;
      });
    },
    newGroup(i, g) {
      var selectGroup = [];
      g.columns.forEach((e) => {
        if (e.select) {
          selectGroup.push(e);
        }
      });
      console.log("clone group");
      this.table.group = [
        ...this.table.group.slice(0, i + 1),
        {
          name: "groupname",
          relationType: 0,
          columns: selectGroup,
        },
        ...this.table.group.slice(i + 1, this.table.group.length),
      ];
    },
  },
  data() {
    return data
  },
};
</script>
