<template>
  <div class="h-full">
    <div class="flex flex-col px-2 mt-2">
      <div class="px-1">
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
        <input
          placeholder="请求前缀"
          v-model="urlprefix"
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
              <input
                v-model="g.relationType"
                type="radio"
                :name="'relationType' + gi"
                :value="0"
              />主表
            </div>
            <div class="px-2">
              <input
                v-model="g.relationType"
                type="radio"
                :name="'relationType' + gi"
                value="1"
              />一对一
            </div>
            <div class="px-2">
              <input
                v-model="g.relationType"
                type="radio"
                :name="'relationType' + gi"
                value="2"
              />一对多
            </div>
            <div class="px-2">
              <input
                v-model="g.relationType"
                type="radio"
                :name="'relationType' + gi"
                value="3"
              />多对多
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

    <!-- <div class="flex border-l-2 border-gray-200" style="width: 100vw">
      <div v-for="l in g.columns" :key="l">
        <div class="px-2 border border-gray-400 flex" v-if="l.listDisplay">
          <div>{{ l.listName }}</div>
          <div class="flex" v-if="l.sortDisplay">
            <ArrowUpIcon class="w-2"></ArrowUpIcon>
            <ArrowDownIcon class="w-2"></ArrowDownIcon>
          </div>
        </div>
      </div>
    </div>
    <div class="flex border-l-2 border-gray-200">
      <div v-for="l in g.columns" :key="l">
        <div class="px-2 border border-gray-400 flex" v-if="l.detailDisplay">
          <div>{{ l.listName }}</div>
          <div class="flex" v-if="l.required">(必填)</div>
          <div>{{ l.renderType }}</div>
        </div>
      </div>
    </div> -->
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
    return {
      urlprefix: "/v1",
      moduleName: "test",
      moduleDisplayName: "模块显示名称",
      columnsDef: [
        {
          name: "action",
          ref: "操作",
          style: {
            width: "200px",
          },
        },
        {
          name: "名称",
          ref: "name",
        },

        {
          name: "描述",
          ref: "comment",
        },
      ],
      target: "",
      targetList: [
        {
          name: "springboot",
        },
        {
          name: "vue",
        },
      ],
      renderType: [
        {
          name: "none",
        },
        {
          name: "text",
        },
        {
          name: "number",
        },
        {
          name: "image",
        },
        {
          name: "avatar",
        },
        {
          name: "date",
        },
      ],
      table: {
        group: [
          {
            name: "基础信息",
            displayName: "base",
            comment: "基础信息",
            primaryTable: "主表",
            relationType: 0,
            columns: [
              {
                name: "id",
                automaticGenerated: true,
                primaryKey: true,
                comment: "自增id",
                listName: "序号",
                listDisplay: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                name: "name",
                comment: "名称",
                listName: "名称",
                listDisplay: true,
                detailDisplay: true,
                searchDisplay: true,
                required: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                name: "avatar",
                comment: "头像",
                listDisplay: true,
                listName: "头像",
                listRenderType: 3,
                detailDisplay: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                name: "first_name",
                listName: "first_name",
                detailDisplay: true,
                comment: "第一名称",
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                name: "last_name",
                listName: "last_name",
                detailDisplay: true,
                comment: "最后名称",
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                name: "full_name",
                comment: "全名称",
                listDisplay: true,
                listName: "全名",
                detailDisplay: false,
                databaseDisplay: true,
                databaseSource: "first_name+last_name",
                listRenderType: 1,
                detailRenderType: 1,
              },

              {
                name: "phone",
                comment: "手机号",
                listDisplay: true,
                listName: "手机号",
                detailDisplay: true,
                databaseDisplay: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                name: "create_at",
                listName: "创建时间",
                comment: "创建时间",
                sortDisplay: true,
                listRenderType: 5,
                detailRenderType: 5,
              },
            ],
          },
          {
            name: "扩展信息",
            comment: "扩展信息",
            relationType: 0,
            displayName: "extra",
            columns: [
              {
                name: "id",
                automaticGenerated: true,
                primaryKey: true,
                comment: "自增id",
                listName: "序号",
                listDisplay: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                detailDisplay: true,
                name: "description",
                listName: "详细描述 ",
                comment: "备注信息",
              },
            ],
          },
          {
            name: "登录日志",
            comment: "登录日志",
            relationType: 0,
            displayName: "login_history",
            columns: [
              {
                name: "id",
                automaticGenerated: true,
                primaryKey: true,
                comment: "自增id",
                listName: "序号",
                listDisplay: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                detailDisplay: true,
                name: "ip",
                listName: "ip地址 ",
                comment: "IP地址",
                listRenderType: 1,
                detailRenderType: 1,
                listDisplay: true,
                searchDisplay: true,
              },
              {
                detailDisplay: true,
                searchDisplay: true,
                name: "create_at",
                listName: "登录日期 ",
                comment: "登录日期",
                listDisplay: true,
                listRenderType: 5,
                detailRenderType: 5,
              },
            ],
          },
          {
            name: "操作日志",
            comment: "登录日志",
            relationType: 0,
            displayName: "ops_history",
            columns: [
              {
                name: "id",
                automaticGenerated: true,
                primaryKey: true,
                comment: "自增id",
                listName: "序号",
                listDisplay: true,
                listRenderType: 1,
                detailRenderType: 1,
              },
              {
                detailDisplay: true,
                name: "ip",
                listName: "ip地址 ",
                comment: "IP地址",
                listRenderType: 1,
                detailRenderType: 1,
                listDisplay: true,
                searchDisplay: true,
              },
              {
                detailDisplay: true,
                name: "ops_content",
                listName: "操作内容 ",
                comment: "操作内容",
                listRenderType: 1,
                detailRenderType: 1,
                listDisplay: true,
                searchDisplay: true,
              },
              {
                detailDisplay: true,
                searchDisplay: true,
                name: "create_at",
                listName: "登录日期 ",
                comment: "登录日期",
                listDisplay: true,
                listRenderType: 5,
                detailRenderType: 5,
              },
            ],
          },
        ],
      },
    };
  },
};
</script>
