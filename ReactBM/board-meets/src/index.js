import React from "react";
import { App } from "./App.jsx";
import "./index.css";
import { BrowserRouter as Router } from "react-router-dom";
import "./i18n.js";
import { createRoot } from "react-dom/client";
import "./index.css";

const rootElement = document.getElementById("root");
const root = createRoot(rootElement);
root.render(
  <React.StrictMode>
    <Router>
      <App />
    </Router>
  </React.StrictMode>
);

