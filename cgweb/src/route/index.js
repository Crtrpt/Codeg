var route = [
  {
    path: "/",
    component: () => import("../layout/Master.vue"),
    redirect :"/table",
    children: [
      {
        name: "table",
        path: "/table",
        component: () => import("../pages/Table.vue"),
      },
    ],
  }
];
export default route;
